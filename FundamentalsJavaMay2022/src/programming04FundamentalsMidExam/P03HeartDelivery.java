package programming04FundamentalsMidExam;

import java.util.Scanner;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] houses = nextIntArray(scanner);

        String commandLine = scanner.nextLine();
        int currentPosition = 0;


        while(!commandLine.equals("Love!")) {

            String[] commandParts = commandLine.split(" ");

            int indexJump = Integer.parseInt(commandParts[1]);
            currentPosition += indexJump;
            if (currentPosition >= houses.length) {
                currentPosition = 0;
            }
            if(houses[currentPosition] > 0) {
                houses[currentPosition] -= 2;
                if(houses[currentPosition] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentPosition);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", currentPosition);
            }

            commandLine = scanner.nextLine();
        }
        int failed = 0;
        for (int i = 0; i < houses.length ; i++) {
            if (houses[i] != 0) {
                failed++;
            }
        }
        System.out.printf("Cupid's last position was %d.%n", currentPosition);
        if (failed > 0) {
            System.out.printf("Cupid has failed %d places.", failed);
        } else {
            System.out.println("Mission was successful.");
        }
    }

    private static int[] nextIntArray(Scanner scanner) {
        String[] intsToString = scanner.nextLine().split("@");
        int[] array = new int[intsToString.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(intsToString[i]);
        }
        return array;
    }
}
