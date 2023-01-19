package iteratorsAndComparatorsExercise.p07EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> firstSet = new TreeSet<>(new ComparatorByHash());
        Set<Person> secondSet = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        IntStream.range(0, n)
                .mapToObj(input -> scanner.nextLine().split("\\s+"))
                .forEach(input -> {
                    String name = input[0];
                    int age = Integer.parseInt(input[1]);
                    Person person = new Person(name, age);
                    firstSet.add(person);
                    secondSet.add(person);
                });
        System.out.printf("%d%n%d", firstSet.size(), secondSet.size());
    }
}
