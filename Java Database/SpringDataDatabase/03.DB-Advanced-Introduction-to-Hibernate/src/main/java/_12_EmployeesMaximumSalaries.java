import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class _12_EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT e.department.name, MAX(e.salary)" +
                        " FROM Employee e " +
                        "GROUP BY e.department.name " +
                        "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                .forEach(obj -> System.out.println(obj[0] + " " + obj[1]));

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
