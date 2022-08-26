package basicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;
        double finalPrice = 0;
        for (int i = 0; i < n ; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            totalPrice = (days * capsulesCount) * pricePerCapsule;
            finalPrice = finalPrice + totalPrice;
            System.out.printf("The price for the coffee is: $%.2f%n", totalPrice);

        }
        System.out.printf("Total: $%.2f", finalPrice);
    }
}
