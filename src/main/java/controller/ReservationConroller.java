package controller;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ReservationService;

import java.io.IOException;
import java.time.LocalDate;

public class ReservationConroller {
    public ReservationService reservationService = new ReservationService();

    public void destroy(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        int id = Integer.parseInt(request.getParameter("reservationId"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-cfg");
        EntityManager em = emf.createEntityManager();
        reservationService.destroy(id, em);
        em.close();
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }

    public void save(HttpServletRequest request, HttpServletResponse response, Employee user) throws IOException {
        String equipmentId = request.getParameter("equipmentId");
        String returnDate = request.getParameter("returnDate");
        String reservationDate = request.getParameter("reservationDate");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-cfg");
        EntityManager em = emf.createEntityManager();
        reservationService.save(Integer.parseInt(equipmentId) ,user, LocalDate.parse(returnDate) ,LocalDate.parse(reservationDate), em);
        response.sendRedirect(request.getContextPath() + "/dashboard");
        em.close();
    }
}
