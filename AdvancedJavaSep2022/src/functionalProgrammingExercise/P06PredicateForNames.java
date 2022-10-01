package functionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());


        List<String> namesList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        Predicate<String> predicate = name -> name.length() <= length;

        namesList.stream().filter(predicate).forEach(System.out::println);

    }
}
