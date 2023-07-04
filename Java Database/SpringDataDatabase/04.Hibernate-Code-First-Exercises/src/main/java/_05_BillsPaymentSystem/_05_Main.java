package _05_BillsPaymentSystem;

import _05_BillsPaymentSystem.entities.BankAccount;
import _05_BillsPaymentSystem.entities.BillingDetail;
import _05_BillsPaymentSystem.entities.CreditCard;
import _05_BillsPaymentSystem.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Month;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class _05_Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("code_first");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

//        BankAccount bankAccount = new BankAccount("DSK", "BG126312636");
//        CreditCard creditCard = new CreditCard("Gold", Month.AUGUST, Year.of(2025));
//        User user = new User("Ivan", "Ivanov", "ivan@gmail.com", "123123",
//                new HashSet<>(5, 55));


//        entityManager.persist(bankAccount);
//        entityManager.persist(creditCard);
//        entityManager.persist(user);



        entityManager.getTransaction().commit();
        entityManager.close();
    }
}