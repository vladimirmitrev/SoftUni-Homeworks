package _03_UniversitySystem.entities;

import _02_SalesDatabase.entities.Sale;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.Set;


@Entity(name = "_03_courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    private int credits;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @ManyToOne
    private Teacher teacher;

    public Course() {}

    public Course(String name, String description, Date startDate, Date endDate, int credits) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudents(Student students){
        this.students.add(students);
    }

    public void removeStudents(Student students){
        this.students.remove(students);
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

}
