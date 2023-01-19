package university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }
    public String registerStudent(Student student) {
        if(capacity > getStudentCount()) {
            if(getStudent(student.firstName, student.lastName) != null) {
                return "Student is already in the university";
            } else {
                students.add(student);
                return "Added student " + student.getFirstName() + " " + student.getLastName();
            }

        } else {
            return "No seats in the university";
        }
    }
    public String dismissStudent(Student student) {
        Student studentFound =  getStudent(student.getFirstName(), student.getLastName());
        
        if(studentFound == null) {
            return "Student not found";
        }
        students.remove(student);

        return "Removed student " + studentFound.getFirstName() + " " + studentFound.getLastName();
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream()
                .filter(element -> element.getFirstName().equals(firstName) && element.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }


    public String getStatistics() {
        return students.stream()
                .map(student -> String.format("" + "==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                        student.getFirstName(), student.getLastName(), student.getBestSubject()))
                .collect(Collectors.joining(System.lineSeparator()));



    }
}
