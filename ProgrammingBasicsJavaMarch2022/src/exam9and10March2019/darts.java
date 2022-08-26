package exam9and10March2019;

import java.util.Scanner;

public class darts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        double score = 301;
        double successfulShots = 0;
        double unsuccessfulShots = 0;

        String type = scanner.nextLine();
        while (!(type.equalsIgnoreCase("Retire"))) {


            int points = Integer.parseInt(scanner.nextLine());

            if (type.equalsIgnoreCase("Single")) {
                score -= points;
                if (score >= 0) {
                    successfulShots++;
                } else {
                    unsuccessfulShots++;
                    score += points;
                }
            } else if (type.equalsIgnoreCase("Double")) {
                score -= points * 2;
                if (score >= 0) {
                    successfulShots++;
                } else {
                    unsuccessfulShots++;
                    score += points * 2;
                }
            } else if (type.equalsIgnoreCase("Triple")) {
                score -= points * 3;
                if (score >= 0) {
                    successfulShots++;
                } else {
                    unsuccessfulShots++;
                    score += points * 3;
                }
            }

            if (score == 0) {
                System.out.printf("%s won the leg with %.0f shots.", name, successfulShots);
                break;
            }


            type = scanner.nextLine();
        }

        if ((type.equalsIgnoreCase("Retire"))) {
            System.out.printf("%s retired after %.0f unsuccessful shots.",name,unsuccessfulShots);
        }
    }
}


