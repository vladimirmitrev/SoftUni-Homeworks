package _03_UniversitySystem.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity(name = "_03_students")
public class Student extends Person {
    @Column(name = "average_grade")
    private double averageGrade;

    private int attendance;

    @ManyToMany
    @JoinTable(name = "_03_students_courses",
            joinColumns =
                @JoinColumn(name = "students_id", referencedColumnName = "id"),
            inverseJoinColumns =
                @JoinColumn(name = "courses_id", referencedColumnName = "id"))
    private Set<Course> courses;

    public Student() {
        super();
    }

    public Student(double averageGrade, int attendance) {
        this.averageGrade = averageGrade;
        this.attendance = attendance;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
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

