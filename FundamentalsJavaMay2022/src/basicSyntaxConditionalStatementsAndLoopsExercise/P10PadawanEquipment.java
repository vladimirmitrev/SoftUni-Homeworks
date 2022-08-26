package basicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int countOfStundents = Integer.parseInt(scanner.nextLine());
        double priceSaber = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());

        double saberTotalPrice = Math.ceil(countOfStundents * 1.1) * priceSaber;
        double robeTotalPrice = priceRobe * countOfStundents;
        double beltTotalPrice = (countOfStundents - countOfStundents / 6) * priceBelt;

        double finalPrice = saberTotalPrice + robeTotalPrice + beltTotalPrice;

        if (finalPrice <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", finalPrice);
        }
        if (finalPrice > money) {
            System.out.printf("George Lucas will need %.2flv more.", finalPrice - money);
        }


    }
}
