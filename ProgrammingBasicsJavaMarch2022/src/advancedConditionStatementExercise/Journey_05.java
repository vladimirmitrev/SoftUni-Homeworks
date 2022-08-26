package advancedConditionStatementExercise;

import java.util.Scanner;

public class Journey_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        String typeSleeping = "";

        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equals("summer")) {
                typeSleeping = "Camp";
                budget = budget * 0.3;
            } else if (season.equals(("winter"))) {
                typeSleeping = "Hotel";
                budget = budget * 0.7;
            }
        } else if (budget > 100 && budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")) {
                typeSleeping = "Camp";
                budget = budget * 0.4;
            } else if (season.equals("winter")) {
                typeSleeping = "Hotel";
                budget = budget * 0.8;
            }
        } else if (budget > 1000) {
            destination = "Europe";
            typeSleeping = "Hotel";
            budget = budget * 0.9;
        }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", typeSleeping, budget);
    }
}
