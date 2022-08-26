package selfTesting;

import java.util.Scanner;

public class Petshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogBags = Integer.parseInt(scanner.nextLine());
        int catBags = Integer.parseInt(scanner.nextLine());

        double dogPrice = dogBags * 2.5;
        double catPrice = catBags * 4;
        double total = dogPrice + catPrice;

        System.out.printf("%.2f lv.", total);

    }
}
