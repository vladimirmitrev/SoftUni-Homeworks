package methodsExercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        long fact1 = calculateFactorial(firstNum);
        long fact2 = calculateFactorial(secondNum);

        double result = fact1 * 1.0 / fact2;

        System.out.printf("%.2f", result);

    }
    private static long calculateFactorial (int number) {
        long fact = 1;
        for (int i = 1 ; i <= number ; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
