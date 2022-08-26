package preExamJava1004;

import java.util.Scanner;

public class P01ChristmasPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int paperCount = Integer.parseInt(scanner.nextLine());
        int fabricCount = Integer.parseInt(scanner.nextLine());
        double literGlue = Double.parseDouble(scanner.nextLine());
        int percentDiscount = Integer.parseInt(scanner.nextLine());

        double paperPrice = paperCount * 5.80;
        double fabricPrice = fabricCount * 7.20;
        double gluePrice = literGlue * 1.20;
        double totalPrice = paperPrice + fabricPrice + gluePrice;

        double finalPrice = totalPrice - (totalPrice * percentDiscount / 100);

        System.out.printf("%.3f", finalPrice);

    }
}
