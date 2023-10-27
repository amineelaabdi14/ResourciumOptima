package controller;

import entities.Equipment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EquipmentService;
import service.ReservationService;

import java.io.IOException;
import java.util.List;

public class EquipmentController {
    private EquipmentService equipmentService = new EquipmentService();
    private ReservationService reservationService = new ReservationService();

    public void renderDashboard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-cfg");
        EntityManager em = entityManagerFactory.createEntityManager();
        RequestDispatcher dashboardDispatcher = request.getRequestDispatcher("WEB-INF/dashboard.jsp");
        List<Equipment> equipments = equipmentService.getEquipments(em);
        List<Equipment> equipmentsToEmployees = reservationService.getBookedEquipments(em);
        em.close();
        request.setAttribute("equipments", equipments);
        request.setAttribute("equipmentsToEmployees", equipmentsToEmployees);
        dashboardDispatcher.forward(request, response);
    }
    public void deleteEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("equipmentId");
        RequestDispatcher dashboardDispatcher = request.getRequestDispatcher("WEB-INF/dashboard.jsp");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-cfg");
        EntityManager em = entityManagerFactory.createEntityManager();
        equipmentService.delete(Integer.parseInt(id), em);
        em.close();
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }

    public void addEquipment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String quantity = request.getParameter("quantity");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-cfg");
        EntityManager em = entityManagerFactory.createEntityManager();
        Equipment equipment = new Equipment(name, type, Integer.parseInt(quantity));
        equipmentService.addEquipment(equipment, em);
        em.close();
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}
