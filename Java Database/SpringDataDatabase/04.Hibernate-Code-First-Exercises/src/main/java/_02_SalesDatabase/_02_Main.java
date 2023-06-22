package _02_SalesDatabase;

import _02_SalesDatabase.entities.Customer;
import _02_SalesDatabase.entities.Product;
import _02_SalesDatabase.entities.Sale;
import _02_SalesDatabase.entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class _02_Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("code_first");

        EntityManager entityManager = factory.createEntityManager();

        Customer customer = new Customer("John Doe", "john_doe@gmail.com", "12345678901234");
        Product product = new Product("Phone", 1, 550.55);
        StoreLocation storeLocation = new StoreLocation("Metro");
        Sale sale = new Sale(product, customer, storeLocation, LocalDateTime.now());

        entityManager.persist(customer);
        entityManager.persist(product);
        entityManager.persist(storeLocation);
        entityManager.persist(sale);

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}