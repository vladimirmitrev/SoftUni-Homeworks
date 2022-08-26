package advancedConditionStatementExercise;

import java.util.Scanner;

public class OperationsBetweenNumbers_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        double result = 0;
        String evenOrOdd = "";
        boolean isZero = false;

        switch (operator) {
            case "+":
                result = numberOne + numberTwo;

                break;
            case "-":
                result = numberOne - numberTwo;

                break;
            case "*":
                result = numberOne * numberTwo;

                break;
            case "/":
                if (numberTwo == 0) {
                    isZero = true;
                } else {
                    result = numberOne * 1.0 / numberTwo;
                }

                break;
            case "%":
                if (numberTwo == 0) {
                    isZero = true;
                } else {
                    result = numberOne % numberTwo;
                }
                break;
        }
        if (result % 2 == 0) {
            evenOrOdd = "even";
        } else {
            evenOrOdd = "odd";
        }
        if (operator.equals("+") || operator.equals("-") || operator.equals("*")) {
            System.out.printf("%d %s %d = %.0f - %s", numberOne, operator, numberTwo, result, evenOrOdd);
        } else if (operator.equals("/") && !isZero) {
            System.out.printf("%d %s %d = %.2f", numberOne, operator, numberTwo, result);
        } else if (operator.equals("%") && !isZero) {
            System.out.printf("%d %s %d = %.0f", numberOne, operator, numberTwo, result);
        } else {
            System.out.printf("Cannot divide %d by zero", numberOne);
        }
    }
}
