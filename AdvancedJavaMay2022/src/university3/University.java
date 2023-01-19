package university3;

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

            String result = null;

            if (capacity <= students.size()) {
                result = "No seats in the university";
            }
            if(getStudent(student.firstName, student.lastName) != null) {
                result = "Student is already in the university";
            }
            if(result == null) {
                students.add(student);
                result = "Added student " + student.getFirstName() + " " + student.getLastName();
            }
            return result;
    }
    public String dismissStudent(Student student) {
        Student foundStudent = getStudent(student.getFirstName(), student.getLastName());

        if(foundStudent == null) {
            return "Student not found";
        }
        students.remove(student);

        return "Removed student" + foundStudent.getFirstName() + " " + foundStudent.getLastName();
    }

    public Student getStudent(String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        return students.stream()
                .map(student -> String.format(
                        "==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                        student.getFirstName(), student.getLastName(), student.getBestSubject()))
                .collect(Collectors.joining(System.lineSeparator()));
    }


}
