package arraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstLine = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondLine = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;
        boolean isDifferent = false;
        for (int i = 0; i < firstLine.length; i++) {
            sum += firstLine[i];

            if (firstLine[i] != secondLine[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                isDifferent = true;
                break;
            }
        }
        if (!isDifferent) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
