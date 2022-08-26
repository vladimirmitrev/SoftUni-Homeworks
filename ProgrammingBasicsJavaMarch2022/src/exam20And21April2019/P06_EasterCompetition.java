package exam20And21April2019;

import java.util.Scanner;

public class P06_EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int breadCount = Integer.parseInt(scanner.nextLine());
        String bestBaker = "";
        int bestBakerPoints = 0;

        for (int i = 1; i <= breadCount ; i++) {

            String name = scanner.nextLine();
            int points = 0;
            String command = scanner.nextLine();

            while (!command.equals("Stop")) {
                points += Integer.parseInt(command);

                command = scanner.nextLine();

            }
            System.out.printf("%s has %d points.%n", name, points);
            if (points > bestBakerPoints) {
                bestBaker = name;
                bestBakerPoints = points;
                System.out.printf("%s is the new number 1!%n", bestBaker);
            }
        }
        System.out.printf("%s won competition with %d points!", bestBaker, bestBakerPoints);
    }
}
