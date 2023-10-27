package service;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.mindrot.jbcrypt.BCrypt;
import repository.EmployeeRepository;

import java.util.List;
public class EmployeeService{
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    public Employee login (String email,String password, EntityManager em){
        List<Employee> users = employeeRepository.login(email,password,em);
        if (users.size() == 0) {
            return null;
        }
        Employee user = users.get(0);
        if(BCrypt.checkpw(password, user.getPassword())) return user;
        return null;
    }
    public Employee register(String email, String name, String password, EntityManager em){
        try{
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            Employee employee = new Employee(hashedPassword, name, email);;
            return employeeRepository.register(employee, em);
        }catch(Exception e){
            System.out.println("service" + e.getMessage());
            return null;
        }

    }
    public boolean isEmailTaken(String email, EntityManager em){
        List<Employee> users = employeeRepository.isEmailTaken(email, em);
        if (users.size() > 0) {
            return true;
        }
        return false;
    }

}