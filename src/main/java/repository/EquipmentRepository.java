package repository;

import entities.Equipment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class EquipmentRepository {
    public boolean delete(int equipmentId , EntityManager em){
        Query query = em.createQuery("Delete  from Equipment e where e.id = :equipmentId").setParameter("equipmentId", equipmentId);
        try{
            em.getTransaction().begin();
            int result = query.executeUpdate();
            em.getTransaction().commit();
            if (result == 0){
                return false;
            }
            return true;

        }catch (Exception e){
            return false;
        }
    }
    public boolean save(Equipment equipment, EntityManager em) {
        try{
            em.getTransaction().begin();
            em.persist(equipment);
            em.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }
   public List<Equipment> getEquipments(EntityManager em) {
       Query query = em.createQuery("select e from Equipment e");
       List<Equipment> equipment = query.getResultList();
       equipment.stream().forEach(element->{
           System.out.println(element.getName());
       });
       return equipment;
   }
}
