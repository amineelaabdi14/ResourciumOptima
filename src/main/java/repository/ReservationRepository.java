package repository;

import entities.Equipment;
import entities.EquipmentToEmployee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ReservationRepository {
    public List<Equipment> getBookedEquipments(EntityManager em){
        Query query = em.createQuery("SELECT e FROM EquipmentToEmployee e");
        return  query.getResultList();
    }
    public boolean destroy(int id, EntityManager em){
        try{
            em.getTransaction().begin();
            EquipmentToEmployee equipmentToEmployee = em.find(EquipmentToEmployee.class, id);
            em.remove(equipmentToEmployee);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            System.out.println("repository" + e.getMessage());
            return false;
        }
    }
}
