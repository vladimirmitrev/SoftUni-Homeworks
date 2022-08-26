package exam28and29March2020;

import java.util.Scanner;

public class P05_CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalFoodKg = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int totalFoodGrams = totalFoodKg * 1000;
        int totalEatenFood = 0;

        while (!command.equals("Adopted")) {
            int dayFood = Integer.parseInt(command);
            totalEatenFood = totalEatenFood + dayFood;

            command = scanner.nextLine();

        }
        if (totalFoodGrams >= totalEatenFood) {
            System.out.printf("Food is enough! Leftovers: %d grams.", totalFoodGrams - totalEatenFood);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", Math.abs(totalFoodGrams - totalEatenFood));
        }
    }
}
