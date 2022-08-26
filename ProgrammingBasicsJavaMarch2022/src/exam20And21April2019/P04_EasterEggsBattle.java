package exam20And21April2019;

import java.util.Scanner;

public class P04_EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstPlayerQty = Integer.parseInt(scanner.nextLine());
        int secondPlayerQty = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("End")) {

            if (command.equals("one")) {
                secondPlayerQty--;
            } else if (command.equals("two")) {
                firstPlayerQty--;
            }
            if (firstPlayerQty == 0) {
                System.out.printf("Player one is out of eggs. Player two has %d eggs left.", secondPlayerQty);
                break;
            } else if (secondPlayerQty == 0) {
                System.out.printf("Player two is out of eggs. Player one has %d eggs left.", firstPlayerQty);
                break;
            }
            command = scanner.nextLine();

        }
        if (command.equals("End")) {
            System.out.printf("Player one has %d eggs left.%n", firstPlayerQty);
            System.out.printf("Player two has %d eggs left.%n", secondPlayerQty);
        }
    }
}
