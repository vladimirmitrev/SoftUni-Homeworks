package preExamJava1004;

import java.util.Scanner;

public class P05_BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        int currentMostGoals = 0;
        String playerBest = "";

        while (!command.equals("END")) {

            int currentGoals = Integer.parseInt(scanner.nextLine());

            if (currentGoals > currentMostGoals) {
                currentMostGoals = currentGoals;
                playerBest = command;
            }
            if (currentGoals >= 10) {
                break;
            }

            command = scanner.nextLine();
        }
        System.out.printf("%s is the best player!%n", playerBest);
        if (currentMostGoals >= 3) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", currentMostGoals);
        } else {
            System.out.printf("He has scored %d goals.", currentMostGoals);
        }

    }
}
