package exam20And21April2019;

import java.util.Scanner;

public class P04_EasterShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentEggsSum = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();


        int soldEggs = 0;


        while (!command.equals("Close")) {

            int soldOrNewEggs = Integer.parseInt(scanner.nextLine());

            if (command.equals("Fill")) {
                currentEggsSum = currentEggsSum + soldOrNewEggs;

            } else if (command.equals("Buy")) {
                if (currentEggsSum < soldOrNewEggs) {
                    System.out.printf("Not enough eggs in store!%n");
                    System.out.printf("You can buy only %d.", currentEggsSum);
                    return;
                } else {
                    currentEggsSum = currentEggsSum - soldOrNewEggs;
                }
                soldEggs = soldEggs + soldOrNewEggs;

            }
            command = scanner.nextLine();
        }
        System.out.printf("Store is closed!%n");
        System.out.printf("%d eggs sold.", soldEggs);
    }
}

