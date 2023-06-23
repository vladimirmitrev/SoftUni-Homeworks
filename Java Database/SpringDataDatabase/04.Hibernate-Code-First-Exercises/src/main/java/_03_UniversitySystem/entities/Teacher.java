package _03_UniversitySystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Calendar;
import java.util.Collections;
import java.util.Set;

@Entity(name = "_03_teachers")
public class Teacher extends Person {

    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    @OneToMany(targetEntity = Course.class, mappedBy = "teacher")
    private Set<Course> courses;


    public Teacher() {
        super();
    }

    public Teacher(String email, double salaryPerHour) {
        this.email = email;
        this.salaryPerHour = salaryPerHour;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }


    public void addCourses(Course courses){
        this.courses.add(courses);
    }

    public void removeCourses(Course courses){
        this.courses.remove(courses);
    }

    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }

}
