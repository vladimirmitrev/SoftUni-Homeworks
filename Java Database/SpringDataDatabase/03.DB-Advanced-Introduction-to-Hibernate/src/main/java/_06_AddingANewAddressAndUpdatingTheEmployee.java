import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _06_AddingANewAddressAndUpdatingTheEmployee {
    public static void main(String[] args) {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        String addressText = "Vitoshka 15";

        Address address = new Address();
        address.setText(addressText);
        entityManager.persist(address);

        Scanner scanner = new Scanner(System.in);

        String givenName = scanner.nextLine();

        entityManager
                .createQuery("UPDATE Employee e " +
                        "SET e.address = :address_text " +
                        "WHERE e.lastName = :last_name")
                .setParameter("last_name", givenName)
                .setParameter("address_text", address)
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
