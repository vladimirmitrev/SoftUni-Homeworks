package _01_GringottsDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class _01_Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("code_first");

        EntityManager entityManager = factory.createEntityManager();

        WizzardDeposits wizzardDeposits = new WizzardDeposits(
                "Orion", "Star", "no notes", 33,
                "Betelgeuse", (short)10, "Clusters",
                LocalDateTime.now(), BigDecimal.valueOf(1000), 5.5, 10,
                LocalDateTime.of(2030, 5, 10, 12, 0), false);

        entityManager.persist(wizzardDeposits);

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}