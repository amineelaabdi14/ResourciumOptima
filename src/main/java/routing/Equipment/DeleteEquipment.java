package routing.Equipment;

import controller.EquipmentController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/equipment/delete")
public class DeleteEquipment extends HttpServlet {
    EquipmentController equipmentController = new EquipmentController();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       equipmentController.deleteEquipment(request, response);
    }
}
