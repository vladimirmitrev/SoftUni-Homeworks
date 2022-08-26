package examPreparation;

import java.util.Scanner;

public class P01_EasterLunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBread = Integer.parseInt(scanner.nextLine());
        int eggsDozen = Integer.parseInt(scanner.nextLine());
        int cookieKg = Integer.parseInt(scanner.nextLine());

        double breadPrice = easterBread * 3.20;
        double eggPrice = eggsDozen * 4.35;
        double cookiePrice = cookieKg * 5.40;
        double paintPrice = eggsDozen * 12 * 0.15;

        double totalPrice = breadPrice + eggPrice + cookiePrice + paintPrice;

        System.out.printf("%.2f", totalPrice);
    }
}
