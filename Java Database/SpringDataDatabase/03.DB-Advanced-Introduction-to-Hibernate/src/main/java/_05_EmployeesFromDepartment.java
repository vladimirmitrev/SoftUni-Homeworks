import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class _05_EmployeesFromDepartment {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        String department = "Research and Development";

        entityManager.createQuery(
                        "SELECT e FROM Employee e " +
                                " WHERE e.department.name = :departmentName" +
                                " ORDER BY e.salary, e.id",
                        Employee.class)
                .setParameter("departmentName", department)
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                        e.getFirstName(), e.getLastName(),
                        department, e.getSalary()));


        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
