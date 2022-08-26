package advancedConditionStatementsLab;

import java.util.Scanner;

public class FruitShop_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double qty = Double.parseDouble(scanner.nextLine());

        double price = 0;
        boolean isValid = true;

        switch (dayOfWeek) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                if (fruit.equals("banana")) {
                    price = 2.5;
                } else if (fruit.equals("apple")) {
                    price = 1.2;
                } else if (fruit.equals("orange")) {
                    price = 0.85;
                } else if (fruit.equals("grapefruit")) {
                    price = 1.45;
                } else if (fruit.equals("kiwi")) {
                    price = 2.7;
                } else if (fruit.equals("pineapple")) {
                    price = 5.5;
                } else if (fruit.equals("grapes")) {
                    price = 3.85;
                } else {
                    isValid = false;
                }
                break;
            case "Saturday":
            case "Sunday":
                if (fruit.equals("banana")) {
                    price = 2.7;
                } else if (fruit.equals("apple")) {
                    price = 1.25;
                } else if (fruit.equals("orange")) {
                    price = 0.9;
                } else if (fruit.equals("grapefruit")) {
                    price = 1.6;
                } else if (fruit.equals("kiwi")) {
                    price = 3;
                } else if (fruit.equals("pineapple")) {
                    price = 5.6;
                } else if (fruit.equals("grapes")) {
                    price = 4.2;
                } else {
                    isValid = false;
                }
                break;

            default:
                isValid = false;
        }
                double total = price * qty;
                if (!isValid) {
                    System.out.println("error");
                } else {
                    System.out.printf("%.2f", total);
                }
                }
        }

