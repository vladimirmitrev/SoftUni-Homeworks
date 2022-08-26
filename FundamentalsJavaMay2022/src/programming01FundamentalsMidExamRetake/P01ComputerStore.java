package programming01FundamentalsMidExamRetake;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        double currentPrice = 0;
        while (!inputLine.equals("special") && !inputLine.equals("regular")) {
            double inputPrice = Double.parseDouble(inputLine);

            if (inputPrice < 0) {
                System.out.println("Invalid price!");
                inputLine = scanner.nextLine();
                continue;
            }

            currentPrice += inputPrice;

            inputLine = scanner.nextLine();

        }
        if (currentPrice == 0) {
            System.out.println("Invalid order!");
        } else {

            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", currentPrice);
            double taxes = currentPrice * 0.20;
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            double finalPrice = currentPrice + taxes;
            if (inputLine.equals("special")) {
                finalPrice = (currentPrice + taxes) * 0.90;
            }
            System.out.printf("Total price: %.2f$", finalPrice);
        }
    }
}
