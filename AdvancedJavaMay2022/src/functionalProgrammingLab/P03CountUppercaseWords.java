package functionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isUpperCase = w -> Character.isUpperCase(w.charAt(0));

       List<String> words = Arrays.stream(scanner.nextLine().split("\\s+"))
               .filter(isUpperCase)
               .collect(Collectors.toList());

        System.out.println(words.size());

        words.forEach(w -> System.out.println(w));
}
}