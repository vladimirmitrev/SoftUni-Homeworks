package bacicSyntaxMoreExercises;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());

        String command = scanner.nextLine();

        double gamePrice = 0;
        double currentMoney = budget;
        double totalSpent = 0;


        while (!command.equals("Game Time")) {

            switch (command) {
                case "OutFall 4":
                    gamePrice = 39.99;
                    totalSpent += gamePrice;
                    currentMoney -= gamePrice;
                    if (currentMoney >= gamePrice) {
                        System.out.println("Bought OutFall 4");
                    }
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    totalSpent += gamePrice;
                    currentMoney -= gamePrice;
                    if (currentMoney >= gamePrice) {
                        System.out.println("Bought CS: OG");
                    }
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    totalSpent += gamePrice;
                    currentMoney -= gamePrice;
                    if (currentMoney >= gamePrice) {
                        System.out.println("Bought Zplinter Zell");
                    }
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    totalSpent += gamePrice;
                    currentMoney -= gamePrice;
                    if (currentMoney >= gamePrice) {
                        System.out.println("Bought Honored 2");
                    }
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    totalSpent += gamePrice;
                    currentMoney -= gamePrice;
                    if (currentMoney >= gamePrice) {
                        System.out.println("Bought RoverWatch");
                    }
                    break;
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    totalSpent += gamePrice;
                    currentMoney -= gamePrice;
                    if (currentMoney >= gamePrice) {
                        System.out.println("Bought RoverWatch Origins Edition");
                    }
                    break;
                default:
                    System.out.println("Not Found");

            }
            command = scanner.nextLine();
        }
        if (gamePrice > currentMoney) {
            System.out.println("Too Expensive");
        }
        if (currentMoney <= 0) {
            System.out.println("Out of money!");
        } else {
            System.out.printf("Total spent: %.2f. Remaining: %.2f", totalSpent, budget - totalSpent);
        }
    }
}
