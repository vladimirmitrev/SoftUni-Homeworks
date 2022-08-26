package moreExercisesConditionalStatementsAdvanced;

import java.util.Scanner;

public class P03_Flowers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chrysaQty = Integer.parseInt(scanner.nextLine());
        int rosesQty = Integer.parseInt(scanner.nextLine());
        int tulipQty = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        double chrysaPrice = 0;
        double rosesPrice = 0;
        double tulipPrice = 0;
        int allFlowersQty = chrysaQty + rosesQty + tulipQty;

        switch (season) {
            case"Spring":
                chrysaPrice = chrysaQty * 2.00;
                rosesPrice = rosesQty * 4.10;
                tulipPrice = tulipQty * 2.50;
                break;
            case "Summer":
                chrysaPrice = chrysaQty * 2.00;
                rosesPrice = rosesQty * 4.10;
                tulipPrice = tulipQty * 2.50;
                break;
            case "Autumn":
                chrysaPrice = chrysaQty * 3.75;
                rosesPrice = rosesQty * 4.50;
                tulipPrice = tulipQty * 4.15;
                break;
            case "Winter":
                chrysaPrice = chrysaQty * 3.75;
                rosesPrice = rosesQty * 4.50;
                tulipPrice = tulipQty * 4.15;
                break;
        }
        double bouquetFirstPrice = chrysaPrice + rosesPrice + tulipPrice;

        if (holiday.equals("Y")) {
            bouquetFirstPrice = bouquetFirstPrice * 1.15;
        }
        if (tulipQty >= 7 && season.equals("Spring")) {
            bouquetFirstPrice = bouquetFirstPrice * 0.95;
        }
        if (rosesQty >= 10 && season.equals("Winter")) {
            bouquetFirstPrice = bouquetFirstPrice * 0.90;
        }
        if (allFlowersQty > 20) {
            bouquetFirstPrice = bouquetFirstPrice * 0.80;
        }
        System.out.printf("%.2f", (bouquetFirstPrice + 2));
    }
}
