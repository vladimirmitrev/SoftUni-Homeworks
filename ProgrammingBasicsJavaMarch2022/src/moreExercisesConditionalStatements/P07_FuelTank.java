package moreExercisesConditionalStatements;

import java.util.Scanner;

public class P07_FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double litersInTank = Double.parseDouble(scanner.nextLine());

        if (litersInTank >= 25) {
            if (fuelType.equals("Diesel")) {
                System.out.printf("You have enough %s.", fuelType.toLowerCase());
            } else if (fuelType.equals("Gasoline")) {
                System.out.printf("You have enough %s.", fuelType.toLowerCase());
            } else if (fuelType.equals(("Gas"))) {
                System.out.printf("You have enough %s.", fuelType.toLowerCase());
            } else {
                System.out.println("Invalid fuel!");
            }
        } else if (litersInTank <= 25) {
            if (fuelType.equals("Diesel")) {
                System.out.printf("Fill your tank with %s!", fuelType.toLowerCase());
            } else if (fuelType.equals("Gasoline")) {
                System.out.printf("Fill your tank with %s!", fuelType.toLowerCase());
            } else if (fuelType.equals(("Gas"))) {
                System.out.printf("Fill your tank with %s!", fuelType.toLowerCase());
            } else {
                System.out.println("Invalid fuel!");
            }
        }
    }
}
