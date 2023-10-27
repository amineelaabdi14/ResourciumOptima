package routing;

import controller.EmployeeController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {"/login", "/register"})
public class Authenticate extends HttpServlet {
    private EmployeeController employeeController = new EmployeeController();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        if (request.getParameter("name") != null) {
            employeeController.register(request, response);
        } else {
            employeeController.login(request, response);
        }
    }
    @Override
    public void destroy() {
        System.out.println("get destroyed");
    }
}
