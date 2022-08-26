package exam20And21April2019;

import java.util.Scanner;

public class P06_EasterDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int clients = Integer.parseInt(scanner.nextLine());

        int itemCount = 0;
        double basketPrice = 1.50;
        double wreathPrice = 3.80;
        double bunnyPrice = 7;
        double totalPrice = 0;
        double finalPrice = 0;


        for (int i = 1; i <= clients; i++) {
            String type = scanner.nextLine();
            while (!type.equals("Finish")) {

                if (type.equals("basket")) {
                    totalPrice += basketPrice;
                    itemCount++;
                }
                if (type.equals("wreath")) {
                    totalPrice += wreathPrice;
                    itemCount++;
                }
                if (type.equals("chocolate bunny")) {
                    totalPrice += bunnyPrice;
                    itemCount++;
                }

                type = scanner.nextLine();
            }
            if (itemCount % 2 == 0) {
                totalPrice = totalPrice * 0.8;
            }
            finalPrice = finalPrice + totalPrice;
            System.out.printf("You purchased %d items for %.2f leva.%n", itemCount ,totalPrice);

            totalPrice = 0;
            itemCount = 0;
        }
        double averagePrice = finalPrice / clients;
        System.out.printf("Average bill per client is: %.2f leva.", averagePrice);

    }
}
