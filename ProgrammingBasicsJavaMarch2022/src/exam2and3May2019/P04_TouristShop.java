package exam2and3May2019;

import java.util.Scanner;

public class P04_TouristShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        int productCount = 0;
        double totalPrice = 0;

        while (!command.equals("Stop")) {
            double productPrice = Double.parseDouble(scanner.nextLine());

            productCount++;
            if (productCount % 3 == 0) {
                productPrice = productPrice / 2;
            }
            totalPrice = totalPrice + productPrice;
            if (totalPrice > budget) {
                System.out.printf("You don't have enough money!%n");
                System.out.printf("You need %.2f leva!", Math.abs(totalPrice - budget));
                break;
            }
            command = scanner.nextLine();
            }

        if (command.equals("Stop")) {
            System.out.printf("You bought %d products for %.2f leva.", productCount, totalPrice);
        }

    }
}
