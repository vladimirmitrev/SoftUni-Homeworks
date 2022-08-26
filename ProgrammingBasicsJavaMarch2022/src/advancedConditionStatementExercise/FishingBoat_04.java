package advancedConditionStatementExercise;

import java.util.Scanner;

public class FishingBoat_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fisherQty = Integer.parseInt(scanner.nextLine());

        double shipRentPrice = 0;

        switch (season) {
            case "Spring":
                shipRentPrice = 3000;
                break;
            case "Summer":
                shipRentPrice = 4200;
                break;
            case "Autumn":
                shipRentPrice = 4200;
                break;
            case "Winter":
                shipRentPrice = 2600;
                break;
        }
        if (fisherQty <= 6) {
            shipRentPrice = shipRentPrice * 0.9;
        } else if (fisherQty > 7 && fisherQty <= 11) {
            shipRentPrice = shipRentPrice * 0.85;
        } else if (fisherQty > 12) {
            shipRentPrice = shipRentPrice * 0.75;
            }
            if (fisherQty % 2 == 0 && !(season.equals("Autumn"))) {
                shipRentPrice = shipRentPrice * 0.95;
            }
            if (shipRentPrice <= budget) {
                System.out.printf("Yes! You have %.2f leva left.", budget - shipRentPrice);
            } else {
                System.out.printf("Not enough money! You need %.2f leva.", shipRentPrice - budget);
        }
    }
}
