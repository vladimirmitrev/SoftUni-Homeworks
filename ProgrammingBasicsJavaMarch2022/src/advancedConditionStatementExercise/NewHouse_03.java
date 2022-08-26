package advancedConditionStatementExercise;

import java.util.Scanner;

public class NewHouse_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowerType = scanner.nextLine();
        int flowerQty = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (flowerType) {
            case "Roses":
                price = flowerQty * 5;
                if (flowerQty > 80) {
                    price = price * 0.9;
                }
                break;
            case "Dahlias":
                price = flowerQty * 3.80;
                if (flowerQty > 90) {
                    price = price * 0.85;
                }
                break;
            case "Tulips":
                price = flowerQty * 2.80;
                if (flowerQty > 80) {
                    price = price * 0.85;
                }
                break;
            case "Narcissus":
                price = flowerQty * 3;
                if (flowerQty < 120) {
                    price = price * 1.15;
                }
                break;
            case "Gladiolus":
                price = flowerQty * 2.50;
                if (flowerQty < 80) {
                    price = price * 1.2;
                }
                break;
        }
        if (price <= budget) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowerQty,
                    flowerType, budget - price);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", price - budget);

        }
    }
}