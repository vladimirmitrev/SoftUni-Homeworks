package objectsAndClassesExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P07OrderByAge {
    static class People {
        private String name;
        private String id;
        private int age;


        public People(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<People> peopleList = new ArrayList<>();
        while (!command.equals("End")) {
            String name = command.split(" ")[0];
            String id = command.split(" ")[1];
            int age = Integer.parseInt(command.split(" ")[2]);

            People people = new People(name, id, age);
            peopleList.add(people);

            command = scanner.nextLine();
        }
        peopleList.sort(Comparator.comparing(People :: getAge));
        for (People people : peopleList) {
            System.out.printf("%s with ID: %s is %d years old.%n", people.getName(), people.getId(), people.getAge() );
        }
    }
}
