import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _08_GetEmployeesWithProject {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        int inputId = Integer.parseInt(scanner.nextLine());

//        Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
//                        "WHERE e.id =  :input_id", Employee.class)
//                .setParameter("input_id", inputId)
//                .getSingleResult();

        Employee employee = entityManager.find(Employee.class, inputId);

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        employee.getProjects().stream()
                .map(Project::getName)
                .sorted(String::compareTo)
                .forEach(pr -> System.out.printf("\t%s%n", pr));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
