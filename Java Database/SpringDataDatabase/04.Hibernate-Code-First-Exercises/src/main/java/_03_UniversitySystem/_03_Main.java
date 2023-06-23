package _03_UniversitySystem;

import _03_UniversitySystem.entities.Course;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

public class _03_Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("code_first");

        EntityManager entityManager = factory.createEntityManager();

//        Course course = new Course(
//                "Java", "Programming with JAVA",
//                Calendar.getInstance().getTime(),
//                Calendar.getInstance().getTime(),
//                27);
//
//        entityManager.persist(course);

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}