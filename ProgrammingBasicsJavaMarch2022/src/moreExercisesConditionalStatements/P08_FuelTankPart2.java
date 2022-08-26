package moreExercisesConditionalStatements;

import java.util.Scanner;

public class P08_FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double fuelQty = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine();

        double fuelPrice = 0;

        if (fuelType.equals("Gas")) {
            fuelPrice = 0.93;
            if (clubCard.equals("Yes")){
                fuelPrice = 0.93 - 0.08;
            }
        } else if (fuelType.equals("Gasoline")) {
            fuelPrice = 2.22;
            if (clubCard.equals("Yes")) {
                fuelPrice = 2.22 - 0.18;
            }
        } else if (fuelType.equals("Diesel")) {
            fuelPrice = 2.33;
            if (clubCard.equals("Yes")) {
                fuelPrice = 2.33 - 0.12;
            }
        }
        double totalFuel = fuelQty * fuelPrice;
        if (fuelQty >= 20 && fuelQty <= 25) {
            totalFuel = totalFuel * 0.92;
        } else if (fuelQty > 25) {
            totalFuel = totalFuel * 0.9;
        }
        System.out.printf("%.2f lv.", totalFuel);
    }
}

