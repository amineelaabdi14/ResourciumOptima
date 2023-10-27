package repository;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class EmployeeRepository {

    public EmployeeRepository() {
    }

    public List<Employee> login(String email, String password, EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        Predicate namePredicate = builder.equal(root.get("email"), email);
        criteria.where(namePredicate);
        TypedQuery<Employee> query = em.createQuery(criteria);
        List<Employee> users = query.getResultList();
        return users;
    }

    public Employee register(Employee employee, EntityManager em) {
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } catch (Exception e) {
            System.out.println("repository" + e.getMessage());
            return null;
        }

    }

    public List<Employee> isEmailTaken(String email, EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        Predicate namePredicate = builder.equal(root.get("email"), email);
        criteria.where(namePredicate);
        TypedQuery<Employee> query = em.createQuery(criteria);
        List<Employee> users = query.getResultList();
        return users;
    }
}
