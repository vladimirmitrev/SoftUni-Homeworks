package exam6and7April2019;

import java.util.Scanner;

public class P04_CinemaVoucher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double voucherPrice = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        double totalPrice = 0;
        double currentPrice = 0;
        int ticketsCount = 0;
        int itemsCount = 0;

        while (!command.equals("End")) {

            if (command.length() > 8) {

                currentPrice = command.charAt(0) + command.charAt(1);
                totalPrice = totalPrice + currentPrice;
                if (currentPrice > voucherPrice) {
                    break;

                }
                ticketsCount++;

            } else if (command.length() < 8){

                currentPrice = currentPrice + command.charAt(0);
                totalPrice = totalPrice + currentPrice;
                if (currentPrice > voucherPrice) {
                    break;
                }
                itemsCount++;
            }

            command = scanner.nextLine();
        }
        System.out.printf("%d%n", ticketsCount);
        System.out.printf("%d", itemsCount);
    }
}