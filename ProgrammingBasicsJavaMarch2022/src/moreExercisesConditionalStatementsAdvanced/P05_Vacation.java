package moreExercisesConditionalStatementsAdvanced;

import java.util.Scanner;

public class P05_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        double campPrice = 0;
        double hutPrice = 0;
        double hotelPrice = 0;

        switch (season) {
            case"Summer":
                campPrice = budget * 0.65;
                hutPrice = budget * 0.80;
                hotelPrice = budget * 0.90;
                break;
            case"Winter":
                campPrice = budget * 0.45;
                hutPrice = budget * 0.60;
                hotelPrice = budget * 0.90;
        }
        if (budget <= 1000 && season.equals("Summer")) {
            System.out.printf("Alaska - Camp - %.2f", campPrice);
        } else if (budget > 1000 && budget <= 3000 && season.equals("Summer")) {
            System.out.printf("Alaska - Hut - %.2f", hutPrice);
        } else if (budget > 3000 & season.equals("Summer")) {
            System.out.printf("Alaska - Hotel - %.2f", hotelPrice);
        } else if (budget <= 1000 && season.equals("Winter")) {
            System.out.printf("Morocco - Camp - %.2f", campPrice);
        } else if (budget > 1000 && budget <= 3000 && season.equals("Winter")) {
            System.out.printf("Morocco - Hut - %.2f", hutPrice);
        } else {
            System.out.printf("Morocco - Hotel - %.2f", hotelPrice);
        }
    }
}
