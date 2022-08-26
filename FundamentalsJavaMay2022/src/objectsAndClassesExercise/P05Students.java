package objectsAndClassesExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P05Students {
    static class Students {
    private String name;
    private String lastName;
    private double grade;

    public Students(String name, String lastName, double grade) {
        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
    }
    public double getGrade() {
        return this.grade;
    }

        @Override
        public String toString(){
            return String.format("%s %s: %.2f",this.name, this.lastName, this.grade);
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Students> studentList = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            String personalData = scanner.nextLine();
            String name = personalData.split(" ")[0];
            String lastName = personalData.split(" ")[1];
            double grade = Double.parseDouble(personalData.split(" ")[2]);

            Students student = new Students(name, lastName, grade);
            studentList.add(student);

        }
        studentList.sort(Comparator.comparingDouble(Students :: getGrade)
                .reversed());
        for (Students student : studentList) {
            System.out.println(student.toString());
        }
    }
}
