package moreExercisesConditionalStatements;

import java.util.Scanner;

public class P06_FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magnoliasQty = Integer.parseInt(scanner.nextLine());
        int hyacinthQty = Integer.parseInt(scanner.nextLine());
        int rosesQty = Integer.parseInt(scanner.nextLine());
        int cactusQty = Integer.parseInt(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double magnoliaPrice = magnoliasQty * 3.25;
        double hyacinthPrice = hyacinthQty * 4;
        double rosesPrice = rosesQty * 3.50;
        double cactusPrice = cactusQty * 8;

        double sumFlowers = magnoliaPrice + hyacinthPrice + rosesPrice + cactusPrice;
        double profit = sumFlowers * 0.95;
        double moneyLeft = profit - giftPrice;
        double moneyOwn = giftPrice - profit;

        if (profit >= giftPrice) {
            System.out.printf("She is left with %.0f leva.", Math.floor(moneyLeft));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(moneyOwn));
        }
    }
}
