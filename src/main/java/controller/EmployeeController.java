package controller;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import service.EmployeeService;

import java.io.IOException;
import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-cfg");
            EntityManager em = emf.createEntityManager();
            boolean isEmailTaken = employeeService.isEmailTaken(email, em);
            if (isEmailTaken) {
                response.sendRedirect("login");
                return ;
            }
            Employee user = employeeService.register(email, name, password, em);
            HttpSession session = request.getSession();
            session.setAttribute("user_fullName", name);
            session.setAttribute("user_email", email);
            session.setAttribute("user_id", user.getId());
            em.close();
        }catch (Exception e){
            System.out.println("controller" + e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }

    public boolean login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-cfg");
        EntityManager em = emf.createEntityManager();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Employee user = employeeService.login(email,password,em);
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/dashboard");
            em.close();
            return true;
        }else{
            em.close();
            return false;
        }
    }
}
