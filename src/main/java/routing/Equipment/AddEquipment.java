package routing.Equipment;

import controller.EquipmentController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/equipment/add")
public class AddEquipment extends HttpServlet {
    public EquipmentController equipmentController = new EquipmentController();
    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        equipmentController.addEquipment(request, response);
    }
}
