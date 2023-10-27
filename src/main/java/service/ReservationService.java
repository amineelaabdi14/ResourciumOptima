package service;

import entities.Employee;
import entities.Equipment;
import entities.EquipmentToEmployee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import repository.ReservationRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ReservationService {
    ReservationRepository reservationRepository = new ReservationRepository();
    public List<Equipment> getBookedEquipments(EntityManager em) {
        List<Equipment> equipments = reservationRepository.getBookedEquipments(em);
        return equipments;
    }

    public boolean destroy(int id, EntityManager em) {
        return reservationRepository.destroy(id, em);
    }

    public boolean save(int equipmentId, Employee user, LocalDate returnDate, LocalDate startDate, EntityManager em){
        try{
            em.getTransaction().begin();
            Equipment equipment = em.find(Equipment.class, equipmentId);
            equipment.setCount(equipment.getCount() - 1);
            EquipmentToEmployee equipmentToEmployee = new EquipmentToEmployee();
            equipmentToEmployee.setEquipmentId(equipment);
            equipmentToEmployee.setEmployeeId(user);
            equipmentToEmployee.setEndDate(returnDate);
            equipmentToEmployee.setStartDate(startDate);
            em.persist(equipmentToEmployee);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            System.out.println("repository" + e.getMessage());
            return false;
        }
    }
}
