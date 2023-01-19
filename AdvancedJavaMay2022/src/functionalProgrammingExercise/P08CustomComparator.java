package functionalProgrammingExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0) {
                return -1;
            } else if (num2 % 2 == 0 && num1 % 2 != 0) {
                return 1;
            } else {
                return num1.compareTo(num2);

            }
        };
        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
    }
}
