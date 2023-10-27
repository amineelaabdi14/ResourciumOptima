package routing.pages;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginPage",value = {"/authenticate"})
public class Authentication extends HttpServlet {
    @Override
    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
            RequestDispatcher dashboardDispatcher = request.getRequestDispatcher("WEB-INF/auth.jsp");
            dashboardDispatcher.forward(request, response);
    }
    @Override
    public void destroy() {
        System.out.println("get destroyed");
    }
}