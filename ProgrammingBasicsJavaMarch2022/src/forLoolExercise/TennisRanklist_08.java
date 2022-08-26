package forLoolExercise;

import java.util.Scanner;

public class TennisRanklist_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int startPoints = Integer.parseInt(scanner.nextLine());

        int winCount = 0;
        double pointsFromTour = 0;

        for (int i = 1; i <=n ; i++) {

            String stage = scanner.nextLine();

            switch (stage) {
                case "W":
                    startPoints = startPoints + 2000;
                    winCount++;
                    pointsFromTour = pointsFromTour + 2000;

                    break;
                case "F":
                    startPoints = startPoints + 1200;
                    pointsFromTour = pointsFromTour + 1200;
                    break;
                case "SF":
                    startPoints = startPoints + 720;
                    pointsFromTour = pointsFromTour + 720;
                    break;
            }
        }
        double averageWinningPoints = Math.floor(pointsFromTour / n);
        double winningPercent = winCount * 1.0 / n * 100;

        System.out.printf("Final points: %d%n", startPoints);
        System.out.printf("Average points: %.0f%n", averageWinningPoints);
        System.out.printf("%.2f%%", winningPercent);


    }
}
