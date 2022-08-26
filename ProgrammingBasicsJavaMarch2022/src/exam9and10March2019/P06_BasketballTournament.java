package exam9and10March2019;

import java.util.Scanner;

public class P06_BasketballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tournament = scanner.nextLine();

        int firstTeamScore = 0;
        int secondTeamScore = 0;
        int winCount = 0;
        int lostCount = 0;
        int totalMatches = 0;

        while (!tournament.equals("End of tournaments")) {
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= n; i++) {
                String input = scanner.nextLine();
                int score1 = Integer.parseInt(input);
                int score2 = Integer.parseInt(scanner.nextLine());
                totalMatches++;

                if (score1 > score2) {
                    winCount++;
                    firstTeamScore = score1 - score2;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n", i, tournament, firstTeamScore);
                } else if (score2 > score1) {
                    lostCount++;
                    secondTeamScore = score2 - score1;
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", i, tournament, secondTeamScore);
                }

            }
            tournament = scanner.nextLine();

        }
        double percentWin = winCount * 1.0 / totalMatches * 100;
        double percentLost = lostCount * 1.0 / totalMatches * 100;

        System.out.printf("%.2f%% matches win%n", percentWin);
        System.out.printf("%.2f%% matches lost", percentLost);
    }
}