package moreExercisesConditionalStatements;

import java.util.Scanner;

public class P05_Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysGone = Integer.parseInt(scanner.nextLine());
        int totalFood = Integer.parseInt(scanner.nextLine());
        double dogFoodDaily = Double.parseDouble(scanner.nextLine());
        double catFoodDaily = Double.parseDouble(scanner.nextLine());
        double turtleFoodDaily = Double.parseDouble(scanner.nextLine());

        double turtleFoodKg = daysGone * turtleFoodDaily / 1000;
        double dogFoodKg = daysGone * dogFoodDaily;
        double catFoodKg = daysGone * catFoodDaily;
        double totalFoodNeeded = turtleFoodKg + dogFoodKg + catFoodKg;
        double foodLeft = totalFood - totalFoodNeeded;
        double foodNeeded = Math.abs(totalFoodNeeded - totalFood);

        if (totalFoodNeeded <= totalFood) {
            System.out.printf("%.0f kilos of food left.", Math.floor(foodLeft));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(foodNeeded));
        }
    }
}
