package moreExercisesNestedLoops;

import java.util.Scanner;

public class P11_HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;

        for (int i = 1; i <= days ; i++) {
            double pricePerDay = 0;
            double pricePerHour = 0;
            for (int j = 1; j <= hours ; j++) {
                if (i % 2 == 0 && j % 2 != 0) {
                    pricePerHour = 2.50;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    pricePerHour = 1.25;
                } else {
                    pricePerHour = 1;
                }
                pricePerDay = pricePerDay + pricePerHour;

            }
            totalPrice = pricePerDay + totalPrice;
            System.out.printf("Day: %d - %.2f leva%n", i, pricePerDay);
        }
        System.out.printf("Total: %.2f leva", totalPrice);
    }
}
