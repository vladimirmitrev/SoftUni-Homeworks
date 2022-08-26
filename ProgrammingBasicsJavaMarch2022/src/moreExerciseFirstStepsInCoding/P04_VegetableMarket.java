package moreExerciseFirstStepsInCoding;

import java.util.Scanner;

public class P04_VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vegetablePrice = Double.parseDouble(scanner.nextLine());
        double fruitPrice = Double.parseDouble(scanner.nextLine());
        int vegetableKilos = Integer.parseInt(scanner.nextLine());
        int fruitKilos = Integer.parseInt(scanner.nextLine());

        double vegetableTotalPrice = vegetablePrice * vegetableKilos;
        double fruitTotalPrice = fruitPrice * fruitKilos;
        double totalPriceInBgn = vegetableTotalPrice + fruitTotalPrice;
        double totalPriceInEuro = totalPriceInBgn / 1.94;

        System.out.printf("%.2f", totalPriceInEuro);
    }
}
