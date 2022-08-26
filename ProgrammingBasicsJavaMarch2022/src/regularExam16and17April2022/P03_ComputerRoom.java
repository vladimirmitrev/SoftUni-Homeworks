package regularExam16and17April2022;

import java.util.Scanner;

public class P03_ComputerRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String month = scanner.nextLine();
        int hours = Integer.parseInt(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double pricePerPerson = 0;
        double totalPrice = 0;
        double pricePerHour = 0;

        switch (month) {
            case "march":
            case "april":
            case "may":
                if (timeOfDay.equals("day")) {
                    pricePerHour = 10.50;
                } else {
                    pricePerHour = 8.40;
                }
                break;

            case "june":
            case "july":
            case "august":
                if (timeOfDay.equals("day")) {
                    pricePerHour = 12.60;
                } else {
                    pricePerHour = 10.20;
                }
                break;

        }

        if (peopleCount >= 4) {
            pricePerHour = pricePerHour * 0.9;
        }
        if (hours >= 5) {
            pricePerHour = pricePerHour * 0.5;
        }

        totalPrice = pricePerHour * hours * peopleCount;

        System.out.printf("Price per person for one hour: %.2f%n", pricePerHour);
        System.out.printf("Total cost of the visit: %.2f", totalPrice);

    }
}
