package iteratorsAndComparatorsExercise.p05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);
            people.add(person);

            input = scanner.nextLine();
        }
        int comparePersonIndex = Integer.parseInt(scanner.nextLine());

        Person personToCompare = people.get(comparePersonIndex - 1);

        int totalPeople = people.size();
        int samePeople = 0;
        int differentPeople = 0;

        for (Person person : people) {
            if(person.compareTo(personToCompare) == 0) {
                samePeople++;
            } else {
                differentPeople++;
            }
        }
        if(samePeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", samePeople, differentPeople, totalPeople);
        }

    }
}
