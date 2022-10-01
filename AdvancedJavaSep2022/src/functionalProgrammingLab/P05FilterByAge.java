package functionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P05FilterByAge {

    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = IntStream.range(0, n)
                .mapToObj(i -> readPerson(scanner))
                .collect(Collectors.toList());



//        List<Person> people = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            String[] data = scanner.nextLine().split(", ");
//            String name = data[0];
//            int age = Integer.parseInt(data[1]);
//
//            Person p = new Person(name, age);
//            people.add(p);
//        }

        String ageCondition = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String outputFormat = scanner.nextLine();

        people = filterByAge(people, getPredicate(ageCondition, ageFilter));

        Consumer<Person> printer = getPrinter(outputFormat);

        people.forEach(printer);
        
    }

    public static Person readPerson (Scanner scanner) {
        String[] data = scanner.nextLine().split(", ");
        String name = data[0];
        int age = Integer.parseInt(data[1]);

        Person p = new Person(name, age);
      return p;
    }

    private static Consumer<Person> getPrinter(String outputFormat) {
        switch (outputFormat) {
            case "name":
                return person -> System.out.println(person.name);
            case "age":
                return person -> System.out.println(person.age);
            case "name age":
                return person -> System.out.println(person.name + " - " + person.age);
            default:
                throw  new IllegalArgumentException("Unknown format" + outputFormat);
        }
    }

    private static Predicate<Person> getPredicate(String ageCondition, int ageFilter) {
        switch (ageCondition) {
            case "younger":
                return person -> person.age <= ageFilter;
            case "older":
                return  person -> person.age >= ageFilter;
            default:
                throw new IllegalArgumentException("Invalid parameters for age predicate" + ageCondition + " " + ageFilter);
        }
    }

    private static List<Person> filterByAge(List<Person> people, Predicate<Person> predicate) {
        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
