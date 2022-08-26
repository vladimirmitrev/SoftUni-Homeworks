package basicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double sumOfMoney = 0;

        while (!command.equals("Start")) {
            double inserted = Double.parseDouble(command);
            if (inserted != 0.1 && inserted != 0.2 && inserted != 0.5 && inserted != 1 && inserted != 2) {
                System.out.printf("Cannot accept %.2f%n", inserted);
            } else {
                sumOfMoney = sumOfMoney + inserted;
            }
            command = scanner.nextLine();
        }

        String product = scanner.nextLine();

        while (!product.equals("End")) {
            boolean hasMoney = true;
            switch (product) {
                case "Nuts":
                    if (sumOfMoney < 2) {
                        System.out.println("Sorry, not enough money");
                        hasMoney = false;
                    } else {
                        sumOfMoney -= 2;
                    }
                    break;
                case "Water":
                    if (sumOfMoney < 0.7) {
                        System.out.println("Sorry, not enough money");
                        hasMoney = false;
                    } else {
                        sumOfMoney -= 0.7;
                    }
                    break;
                case "Crisps":
                    if (sumOfMoney < 1.5) {
                        System.out.println("Sorry, not enough money");
                        hasMoney = false;
                    } else {
                        sumOfMoney -= 1.5;
                        break;
                    }
                case "Soda":
                    if (sumOfMoney < 0.8) {
                        System.out.println("Sorry, not enough money");
                        hasMoney = false;
                    } else {
                        sumOfMoney -= 0.8;
                    }
                    break;
                case "Coke":
                    if (sumOfMoney < 1) {
                        System.out.println("Sorry, not enough money");
                        hasMoney = false;
                    } else {
                        sumOfMoney -= 1;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    hasMoney = false;
                    break;
            }
            if (!hasMoney) {
                product = scanner.nextLine();
                continue;
            }
            System.out.printf("Purchased %s%n", product);

            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sumOfMoney);
        }
    }
