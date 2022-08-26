package exam6and7July2019;

import java.util.Scanner;

public class P04_Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double targetPrice = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();

        double cocktailPrice = 0;
        double totalPrice = 0;

        while (!command.equals("Party!")) {

            int cocktailCount = Integer.parseInt(scanner.nextLine());

            cocktailPrice = command.length() * cocktailCount;
            if (cocktailPrice % 2 != 0 ) {
                cocktailPrice = cocktailPrice * 0.75;
                totalPrice = totalPrice + cocktailPrice;

            } else {
                totalPrice = totalPrice + cocktailPrice;
            }

            if (totalPrice >= targetPrice) {
                System.out.printf("Target acquired.%n");
                break;
            }

            command = scanner.nextLine();
        }
        if (command.equals("Party!")) {
            System.out.printf("We need %.2f leva more.%n", Math.abs(targetPrice - totalPrice));
        }

        System.out.printf("Club income - %.2f leva.",totalPrice);

    }
}
