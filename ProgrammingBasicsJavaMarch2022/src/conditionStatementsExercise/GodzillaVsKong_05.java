package conditionStatementsExercise;

import java.util.Scanner;

public class GodzillaVsKong_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statists = Integer.parseInt(scanner.nextLine());
        double priceClothesStatist = Double.parseDouble(scanner.nextLine());

        double decorPrice = budget * 0.10;
        double priceClothes = statists * priceClothesStatist;

        if (statists >= 150) {
            priceClothes = priceClothes - (priceClothes * 0.10);
        }

        double totalFilmPrice = decorPrice + priceClothes;

        if(totalFilmPrice > budget){
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", totalFilmPrice - budget);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - totalFilmPrice);
        }

    }
}