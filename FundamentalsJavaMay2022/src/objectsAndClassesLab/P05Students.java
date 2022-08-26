package objectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Students {
    static class Student {
        String firstName;
        String lastName;
        String age;
        String town;

        public Student(String firstName, String lastName, String age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

        public String getTown() {
            return this.town;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();
        while (!input.equals("end")) {
            String[] inputLine = input.split(" ");
            String firstName = inputLine[0];
            String lastName = inputLine[1];
            String age = inputLine[2];
            String town = inputLine[3];

            Student currentStudent = new Student(firstName, lastName, age, town);
            studentList.add(currentStudent);

            input = scanner.nextLine();
        }

        String printTown = scanner.nextLine();

        for (Student item : studentList) {
            if(item.getTown().equals(printTown)) {
                System.out.printf("%s %s is %s years old%n", item.getFirstName(),
                        item.getLastName(),
                        item.getAge());
            }
        }
    }
}
