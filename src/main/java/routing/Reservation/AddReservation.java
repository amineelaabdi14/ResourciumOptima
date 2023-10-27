package routing.Reservation;

import com.mysql.cj.Session;
import controller.ReservationConroller;
import entities.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(value = {"/reservation/add"})
public class AddReservation extends HttpServlet {
    public ReservationConroller reservationController = new ReservationConroller();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee user = (Employee) session.getAttribute("user");
        reservationController.save(request, response,user);
    }
}
