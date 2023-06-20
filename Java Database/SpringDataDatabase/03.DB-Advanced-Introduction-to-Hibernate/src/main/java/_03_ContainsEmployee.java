import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class _03_ContainsEmployee {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        String[] searchedName = scanner.nextLine().split(" ");

        Long employeeCount = entityManager.createQuery
                        ("SELECT COUNT(e) FROM Employee AS e" +
                                        " WHERE e.firstName = :first_name" +
                                        " AND e.lastName = :last_name",
                                Long.class)
                .setParameter("first_name", searchedName[0])
                .setParameter("last_name", searchedName[1])
                .getSingleResult();

        System.out.println(employeeCount > 0 ? "Yes" : "No");

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
