package moreExerciseWhileLoop;

import java.util.Scanner;

public class P02_ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumNeeded = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int prices = 0;
        int cash = 0;
        int card = 0;
        int count = 0;
        int cashPay = 0;
        int cardPay = 0;
        int totalPrice = 0;

        while (!input.equals("End")) {
            prices = Integer.parseInt(input);
            count++;
            if (count % 2 == 0) {
                if (prices < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    cardPay++;
                    card += prices;
                    System.out.println("Product sold!");
                    totalPrice += prices;
                }
            } else {
                if (prices > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    cashPay++;
                    cash += prices;
                    System.out.println("Product sold!");
                    totalPrice += prices;
                }
            }
            if (totalPrice >= sumNeeded) {
                break;
            }
            input = scanner.nextLine();

        } if (totalPrice < sumNeeded) {
            System.out.println("Failed to collect required money for charity.");
        } else {
                double sumCash = cash * 1.0 / cashPay;
                double sumCard = card * 1.0 / cardPay;
            System.out.printf("Average CS: %.2f%n", sumCash);
            System.out.printf("Average CC: %.2f", sumCard);
        }
    }
}
