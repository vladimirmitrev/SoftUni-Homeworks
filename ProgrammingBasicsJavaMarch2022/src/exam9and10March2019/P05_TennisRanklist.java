package exam9and10March2019;

import java.util.Scanner;

public class P05_TennisRanklist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());

        int pointsGained = 0;
        int totalWinsCount = 0;


        for (int i = 1; i <= n ; i++) {
            String stage = scanner.nextLine();

            if (stage.equals("W")) {
                pointsGained = pointsGained + 2000;
                totalWinsCount++;

            } else if (stage.equals("F")) {
                pointsGained += 1200;

            } else if (stage.equals("SF")) {
                pointsGained += 720;
            }

        }
        int totalPoints = startingPoints + pointsGained;
        double averagePoints = Math.floor(pointsGained / (n * 1.0));
        double percentWinning = totalWinsCount / (n * 1.0) * 100;

        System.out.printf("Final points: %d%n", totalPoints);
        System.out.printf("Average points: %.0f%n", averagePoints);
        System.out.printf("%.2f%%", percentWinning);

    }
}
