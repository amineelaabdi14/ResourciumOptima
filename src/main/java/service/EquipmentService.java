package service;

import entities.Equipment;
import jakarta.persistence.EntityManager;
import repository.EquipmentRepository;

import java.util.List;

public class EquipmentService {
    private EquipmentRepository equipmentRepository = new EquipmentRepository();
    public boolean delete(int id,EntityManager em) {
        if(equipmentRepository.delete(id, em)) {
            return true;
        }
        return false;
    }
    public boolean addEquipment(Equipment equipment, EntityManager em) {
        if(equipmentRepository.save(equipment, em)) {
            return true;
        }
        return false;
    }
    public List<Equipment> getEquipments(EntityManager em) {
        List<Equipment> equipment = equipmentRepository.getEquipments(em);
        return equipment;
    }
}
