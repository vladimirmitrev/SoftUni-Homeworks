package moreExeriseForLoop;

import java.util.Scanner;

public class P01_BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyLeft = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int age = 17;

        for (int i = 1800; i <= n ; i++) {
            if (i % 2 == 0) {
                moneyLeft = moneyLeft - 12000;
                age++;
            } else {
                age++;
                moneyLeft = moneyLeft - (12000 + (age * 50));
            }
        }
        if (moneyLeft >= 0) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", moneyLeft);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(moneyLeft));
        }
    }
}
