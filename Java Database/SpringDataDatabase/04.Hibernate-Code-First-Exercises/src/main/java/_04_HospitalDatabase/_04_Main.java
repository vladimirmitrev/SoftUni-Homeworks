package _04_HospitalDatabase;

import _04_HospitalDatabase.entities.Diagnose;
import _04_HospitalDatabase.entities.Medicament;
import _04_HospitalDatabase.entities.Patient;
import _04_HospitalDatabase.entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class _04_Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("code_first");

        EntityManager entityManager = factory.createEntityManager();

        Patient patient = new Patient("John",
                "Doe",
                "111 Sofia",
                "johndoe@gmail.com",
                Calendar.getInstance().getTime(),
                "https://as1.ftcdn.net/v2/jpg/01/38/58/36/1000_F_138583672_qcRVXRtLhbzXii7icj3F7mCBlrgYFhaw.jpg",
                true);

        Diagnose diagnose = new Diagnose();
        diagnose.setName("Healthy");
        diagnose.setComment("Little memory loss");

        Medicament medicament = new Medicament("Ginko Prim");
        medicament.addPatient(patient);

        Visitation visitation = new Visitation();
        visitation.addMedicament(medicament);
        visitation.setPatient(patient);

        visitation.setDiagnose(diagnose);
        visitation.setComment("Very good health");
        patient.addMedicament(medicament);
        patient.addDiagnose(diagnose);


        entityManager.persist(patient);
        entityManager.persist(visitation);
        entityManager.persist(diagnose);
        entityManager.persist(medicament);


        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}