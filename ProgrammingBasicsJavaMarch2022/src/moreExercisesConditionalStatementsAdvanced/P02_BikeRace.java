package moreExercisesConditionalStatementsAdvanced;

import java.util.Scanner;

public class P02_BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniorCount = Integer.parseInt(scanner.nextLine());
        int oldCount = Integer.parseInt(scanner.nextLine());
        String trailType = scanner.nextLine();

        double juniorPrice = 0;
        double oldPrice = 0;


        switch (trailType) {
            case "trail":
                juniorPrice = juniorCount * 5.5;
                oldPrice = oldCount * 7;
                break;
            case "cross-country":
                juniorPrice = juniorCount * 8;
                oldPrice = oldCount * 9.50;
                break;
            case "downhill":
                juniorPrice = juniorCount * 12.25;
                oldPrice = oldCount * 13.75;
                break;
            case "road":
                juniorPrice = juniorCount * 20;
                oldPrice = oldCount * 21.50;
                break;
        }

        double allPrice = juniorPrice + oldPrice;
        int allCount = juniorCount + oldCount;
        if (trailType.equals("cross-country") && allCount >= 50 ) {
            allPrice = allPrice * 0.75;
        }
        double finalMoney = allPrice * 0.95;

        System.out.printf("%.2f", finalMoney);
    }
}
