import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.nio.file.Path.of;

public class _10_IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        List<String> departmentList = Arrays.asList("Engineering", "Tool Design", "Marketing", "Information Services");

        entityManager.createQuery("UPDATE Employee e " +
                        "SET e.salary = e.salary * 1.12 " +
                        "WHERE e.department.id IN :ids")
                .setParameter("ids", List.of(1, 2, 4, 11))
                .executeUpdate();

        entityManager.createQuery("SELECT em FROM Employee em " +
                        "WHERE em.department.name IN :departments", Employee.class)
                .setParameter("departments", departmentList)
                .getResultStream().forEach(employee -> System.out.printf("%s %s ($%.2f)%n",
                        employee.getFirstName(), employee.getLastName(), employee.getSalary()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}