package moreExercisesConditionalStatementsAdvanced;

import java.util.Scanner;

public class P10_MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());

        while (true) {
            if ( num >= 0) {
                double result = num * 2;
            System.out.printf("Result: %.2f%n", result);
            }
            if ( num < 0) {
                System.out.println("Negative number!");
                break;
            }
            num = Double.parseDouble(scanner.nextLine());
        }
    }
}

