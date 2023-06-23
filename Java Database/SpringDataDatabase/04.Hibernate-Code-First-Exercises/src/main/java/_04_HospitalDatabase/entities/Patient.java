package _04_HospitalDatabase.entities;

import javax.persistence.*;
import java.util.*;

@Entity(name = "_04_patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;
    private String address;
    private String email;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    private String pictureUrl;

    @Column(name = "has_medical_insurance", nullable = false)
    private boolean insured;
    @OneToMany(mappedBy = "patient")
    private Set<Visitation> visitations;
    @ManyToMany
    @JoinTable(
            name = "_04_patients_diagnoses",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id")
    )
    private Set<Diagnose> diagnoses;
    @ManyToMany
    @JoinTable(
            name = "_04_patients_medicaments",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id")
    )
    private Set<Medicament> medicaments;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String address, String email, Date dateOfBirth, String pictureUrl, boolean insured) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.pictureUrl = pictureUrl;
        this.insured = insured;
        this.visitations = new HashSet<>();
        this.diagnoses = new HashSet<>();
        this.medicaments = new HashSet<>();
    }

    public Patient(String ivan, String ivanov, String mail, Date date, boolean b) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
    public Set<Visitation> getVisitations() {
        return Collections.unmodifiableSet(visitations);
    }

    public void addVisitation(Visitation visitation) {
        this.visitations.add(visitation);
    }

    public Set<Diagnose> getDiagnoses() {
        return Collections.unmodifiableSet(diagnoses);
    }

    public void addDiagnose(Diagnose diagnose) {
        this.diagnoses.add(diagnose);
    }

    public Set<Medicament> getMedicaments() {
        return Collections.unmodifiableSet(medicaments);
    }

    public void addMedicament(Medicament medicament){
        this.medicaments.add(medicament);
    }
}

