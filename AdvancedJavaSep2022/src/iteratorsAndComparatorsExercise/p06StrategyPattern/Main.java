package iteratorsAndComparatorsExercise.p06StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> setByName = new TreeSet<>(new ComparatorByName());
        TreeSet<Person> setByAge = new TreeSet<>(new ComparatorByAge());


        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);

            setByName.add(person);
            setByAge.add(person);
        }
        for (Person person : setByName) {
            System.out.println(person);
        }
        for (Person person : setByAge) {
            System.out.println(person);
        }
    }
}
