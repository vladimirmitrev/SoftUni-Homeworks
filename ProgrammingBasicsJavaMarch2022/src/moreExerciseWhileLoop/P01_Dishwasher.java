package moreExerciseWhileLoop;

import java.util.Scanner;

public class P01_Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int remainingDeter = 750 * Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int pots = 0;
        int dishes = 0;

        while (remainingDeter >= 0) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }
            int items = Integer.parseInt(input);
            counter++;

            if (counter % 3 == 0) {
                int neededDeter = items * 15;
                remainingDeter = remainingDeter - neededDeter;
                if (remainingDeter >= 0) {
                    pots += items;
                }
            } else {
                int neededDeter = items * 5;
                remainingDeter = remainingDeter - neededDeter;

                if (remainingDeter >= 0) {
                    dishes += items;
                }
            }
        }
        if (remainingDeter >= 0) {
            System.out.printf("Detergent was enough!%n");
            System.out.printf("%d dishes and %d pots were washed.%n", dishes, pots);
            System.out.printf("Leftover detergent %d ml.", remainingDeter);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(remainingDeter));
        }
    }
}
