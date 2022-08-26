package methodsLab;

import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        double b = Integer.parseInt(scanner.nextLine());

        calculate(a, operator, b);

    }

    public static double calculate(double a, String operator, double b) {
        double result = 0;

        switch (operator) {
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;

        }
        System.out.printf("%.0f",result);
        return result;

    }
}
