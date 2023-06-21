import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class _09_FindTheLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("FROM Project p " +
                        "ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    System.out.printf("Project name: %s%n",
                            p.getName());
                    System.out.printf("\tProject Description: %s%n",
                            p.getDescription());
                    System.out.printf("\tProject Start Date:%s%n",
                            p.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss.S")));
                    System.out.printf("\tProject End Date:%s%n",
                            p.getEndDate() == null ? "null" : p.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss.S")));
                });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
