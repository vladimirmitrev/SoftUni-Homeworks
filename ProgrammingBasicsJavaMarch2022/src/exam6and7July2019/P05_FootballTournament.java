package exam6and7July2019;

import java.util.Scanner;

public class P05_FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int gamesCount = Integer.parseInt(scanner.nextLine());

        int totalPoints = 0;
        int totalWins = 0;
        int totalLost = 0;
        int totalDrawn = 0;


        for (int i = 1; i <= gamesCount ; i++) {
            String type = scanner.nextLine();
            switch (type) {
                case "W":
                    totalPoints += 3;
                    totalWins++;
                    break;
                case "D":
                    totalPoints += 1;
                    totalDrawn++;
                    break;
                case "L":
                    totalLost++;
                    break;
            }
        }

        double percentWin = totalWins * 1.0 / gamesCount * 100;
        if (gamesCount == 0) {
            System.out.printf("%s hasn't played any games during this season.", name);
        } else {
            System.out.printf("%s has won %d points during this season.%n", name, totalPoints);
            System.out.printf("Total stats:%n");
            System.out.printf("## W: %d%n", totalWins);
            System.out.printf("## D: %d%n", totalDrawn);
            System.out.printf("## L: %d%n", totalLost);
            System.out.printf("Win rate: %.2f%%", percentWin);

        }
    }
}
