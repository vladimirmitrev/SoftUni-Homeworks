import entities.Address;
import entities.Town;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class _13_RemoveTowns {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String inputTown = scanner.nextLine();

        List<Address> addresses = entityManager.
                createQuery("SELECT a FROM Address a WHERE a.town.name = :town", Address.class).
                setParameter("town", inputTown).
                getResultList();

        int deletedAddresses = addresses.size();

        if(deletedAddresses == 0){
            System.out.println("No such town");
            entityManager.close();
            return;
        }

        entityManager.getTransaction().begin();
        addresses.forEach(a -> {
            a.getEmployees().forEach(e -> e.setAddress(null));
            entityManager.remove(a);
        });

        Town townFromDB = entityManager.
                createQuery("SELECT t FROM Town t WHERE t.name = :town", Town.class).
                setParameter("town", inputTown).
                getSingleResult();

        entityManager.remove(townFromDB);

        String address = deletedAddresses == 1 ? "address" : "addresses";
        System.out.printf("%d %s in %s deleted", deletedAddresses, address, inputTown);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}