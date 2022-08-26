package basicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        String peopleType = scanner.nextLine();
        String dayType = scanner.nextLine();
        double price = 0;

        switch (peopleType) {
            case "Students":
               switch (dayType) {
                   case "Friday":
                       price = 8.45;
                       break;
                   case "Saturday":
                       price = 9.80;
                       break;
                   case "Sunday":
                       price = 10.46;
                       break;
                   }
               }
        switch (peopleType) {
            case "Business":
                switch (dayType) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
        }
        switch (peopleType) {
            case "Regular":
                switch (dayType) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
        }
        double totalPrice = peopleCount * price;
        if (peopleType.equals("Students") && peopleCount >= 30) {
            totalPrice = totalPrice * 0.85;
        }
        if (peopleType.equals("Business") && peopleCount >= 100) {
            totalPrice = (peopleCount - 10) * price;
        }
        if (peopleType.equals("Regular") && peopleCount >= 10 && peopleCount <= 20) {
            totalPrice = totalPrice * 0.95;
        }
        System.out.printf("Total price: %.2f", totalPrice);

        }
    }
