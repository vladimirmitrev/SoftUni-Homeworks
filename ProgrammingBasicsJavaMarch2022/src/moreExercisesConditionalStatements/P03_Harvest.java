package moreExercisesConditionalStatements;

import java.util.Scanner;

public class P03_Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vineYardSize = Integer.parseInt(scanner.nextLine());
        double grapesPerMeter = Double.parseDouble(scanner.nextLine());
        int wineNeeded = Integer.parseInt(scanner.nextLine());
        int workersNum = Integer.parseInt(scanner.nextLine());

        double totalGrape = vineYardSize * grapesPerMeter;
        double totalWine = totalGrape * 0.4 / 2.5;
        double wineDifference = Math.abs(totalWine - wineNeeded);
        double litersPerPerson =  wineDifference / workersNum;


        if (wineNeeded <= totalWine) {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(totalWine));
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(wineDifference), Math.ceil(litersPerPerson));
        } else {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(wineDifference));
        }
    }
}
