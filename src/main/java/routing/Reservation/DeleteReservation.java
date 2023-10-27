package routing.Reservation;

import controller.ReservationConroller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/reservation/delete")
public class DeleteReservation extends HttpServlet {
    ReservationConroller reservationController = new ReservationConroller();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reservationController.destroy(request, response);
    }

}
