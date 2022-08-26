package examPreparation;

import java.util.Scanner;

public class P03_MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String years = scanner.nextLine();
        String contractType = scanner.nextLine();
        String mobileInternet = scanner.nextLine();
        int months = Integer.parseInt(scanner.nextLine());

        double price = 0;


        switch (contractType) {
            case "Small":
                if (years.equals("one")) {
                    price = 9.98;
                } else if (years.equals("two")) {
                    price = 8.58;
                }
                break;
            case "Middle":
                if (years.equals("one")) {
                    price = 18.99;
                } else if (years.equals("two")) {
                    price = 17.09;
                }
                break;
            case "Large":
                if (years.equals("one")) {
                    price = 25.98;
                } else if (years.equals("two")) {
                    price = 23.59;
                }
                break;
            case "ExtraLarge":
                if (years.equals("one")) {
                    price = 35.99;
                } else if (years.equals("two")) {
                    price = 31.79;
                }
                break;
        }

        if (mobileInternet.equals("yes")) {
            if (price <= 10) {
                price = price + 5.50;
            } else if (price <= 30){
                price = price + 4.35;
            } else {
                price = price + 3.85;
            }
        }
        double totalPrice = price * months;
        if (years.equals("two")) {
            totalPrice = totalPrice - (totalPrice * 0.0375);
        }
        System.out.printf("%.2f lv.", totalPrice);
    }
}
