package moreExercisesConditionalStatementsAdvanced;

import java.util.Scanner;

public class P04_CarTGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        double economyClass = 0;
        double compactClass = 0;
        double luxuryClass = 0;

        switch (season) {
            case"Summer":
                economyClass = budget * 0.35;
                compactClass = budget * 0.45;
                luxuryClass = budget * 0.90;
                break;
            case"Winter":
                economyClass = budget * 0.65;
                compactClass = budget * 0.80;
                luxuryClass = budget * 0.90;
                break;

        }
        if (budget <= 100 && season.equals("Summer")) {
            System.out.printf("Economy class%n");
            System.out.printf("Cabrio - %.2f", economyClass);
        } else if (budget > 100 && budget <= 500 && season.equals("Summer")) {
            System.out.printf("Compact class%n");
            System.out.printf("Cabrio - %.2f", compactClass);
        } else if (budget <= 100 && season.equals("Winter")) {
            System.out.printf("Economy class%n");
            System.out.printf("Jeep - %.2f", economyClass);
        }  else if (budget > 100 && budget <= 500 && season.equals("Winter")) {
            System.out.printf("Compact class%n");
            System.out.printf("Jeep - %.2f", compactClass);
        } else {
            System.out.printf("Luxury class%n");
            System.out.printf("Jeep - %.2f", luxuryClass);
        }
    }
}
