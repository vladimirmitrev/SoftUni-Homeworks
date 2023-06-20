import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class _04_EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        List<String> employeesList = entityManager.
                createQuery("SELECT e.firstName FROM Employee e" +
                                " WHERE e.salary > 50000 ",
                        String.class)
                .getResultList();

        String result = String.join("\n", employeesList);
        System.out.println(result);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
