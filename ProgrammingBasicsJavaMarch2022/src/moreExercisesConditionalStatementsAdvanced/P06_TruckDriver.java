package moreExercisesConditionalStatementsAdvanced;

import java.util.Scanner;

public class P06_TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());

        double money = 0;

        switch (season) {
            case"Spring":
            case"Autumn":
                money = kmPerMonth * 0.75;
                if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                    money = kmPerMonth * 0.95;
                } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
                    money = kmPerMonth * 1.45;
                }
                break;
            case"Summer":
                money = kmPerMonth * 0.90;
                if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                    money = kmPerMonth * 1.10;
                } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
                    money = kmPerMonth * 1.45;
                }
                break;
            case"Winter":
                money = kmPerMonth * 1.05;
                if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                    money = kmPerMonth * 1.25;
                } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
                    money = kmPerMonth * 1.45;
                }
                break;
        }
        double finalMoney = money * 4 * 0.90;
        System.out.printf("%.2f", finalMoney);
    }
}
