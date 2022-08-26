package exam9and10March2019;

import java.util.Scanner;

public class P04_Darts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();

        int startingPoints = 301;
        int successfulShots = 0;
        int unSuccessful = 0;

        String type = scanner.nextLine();


        while (!(type.equalsIgnoreCase("Retire"))) {

            int currentPoints = Integer.parseInt(scanner.nextLine());


            if (type.equalsIgnoreCase("Single")) {
                startingPoints -= currentPoints;
                if (startingPoints >= 0) {
                    successfulShots++;
                } else {
                    unSuccessful++;
                    startingPoints += currentPoints;
                }


            } else if (type.equalsIgnoreCase("Double")) {
                startingPoints -= currentPoints * 2;
                if (startingPoints >= 0) {
                    successfulShots++;
                } else {
                    unSuccessful++;
                    startingPoints += currentPoints * 2;
                }

            } else if (type.equalsIgnoreCase("Triple")) {
                startingPoints -= currentPoints * 3;
                if (startingPoints >= 0) {
                    successfulShots++;
                } else {
                    unSuccessful++;
                    startingPoints += currentPoints * 3;
                }


            }
            if (startingPoints == 0) {
                System.out.printf("%s won the leg with %d shots.", playerName, successfulShots);
                break;
            }
            type = scanner.nextLine();
        }
        if (type.equals("Retire")) {
            System.out.printf("%s retired after %d unsuccessful shots.", playerName, unSuccessful);
        }
    }
}
