package entities;

import jakarta.persistence.*;
import jakarta.servlet.annotation.WebServlet;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class EquipmentToEmployee {
    public EquipmentToEmployee() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public LocalDate startDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        EmployeeId = employeeId;
    }

    public Equipment getEquipmentId() {
        return EquipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        EquipmentId = equipmentId;
    }

    public LocalDate endDate;



    @ManyToOne
    @JoinColumn(name = "Employee_id")
    public Employee EmployeeId;

    @ManyToOne
    @JoinColumn(name = "Equipment_id")
    public Equipment EquipmentId;

}
