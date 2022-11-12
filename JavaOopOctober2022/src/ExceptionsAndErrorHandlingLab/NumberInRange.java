package ExceptionsAndErrorHandlingLab;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int begin = range[0];
        int end = range[1];

        System.out.printf("Range: [%d...%d]%n", begin, end);

        String input = scanner.nextLine();

        boolean isIsRange = false;

        while (!isIsRange) {

            Optional<Integer> number = Optional.empty();

            try {
                number = Optional.of(Integer.parseInt(input));
            } catch (NumberFormatException ignored) {
            }

            if (number.isEmpty() || number.get() < begin || number.get() > end) {
                System.out.println("Invalid number: " + input);
                input = scanner.nextLine();

            } else {
                isIsRange = true;
            }
        }
        System.out.println("Valid number: " + input);
    }
}
