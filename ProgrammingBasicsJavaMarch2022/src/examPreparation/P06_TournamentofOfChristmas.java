package examPreparation;

import java.util.Scanner;

public class P06_TournamentofOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double totalDaysSum = 0;
        int countDaysWin = 0;
        int countDaysLost = 0;

        for (int i = 1; i <= days ; i++) {
            double daySum = 0;

            int dayCountWin = 0;
            int dayCountLose = 0;

            String input = scanner.nextLine();
            while (!input.equals("Finish")) {
                String status = scanner.nextLine();
                if (status.equals("win")) {
                    daySum = daySum + 20;
                    dayCountWin++;
                } else if (status.equals("lose")) {
                    dayCountLose++;
                }

                input = scanner.nextLine();
            }
            if (dayCountWin > dayCountLose) {
                countDaysWin++;
                daySum = daySum * 1.10;
            } else {
               countDaysLost++;
            }

            totalDaysSum = totalDaysSum + daySum;
        }
        if (countDaysWin > countDaysLost) {
            totalDaysSum = totalDaysSum * 1.20;
            System.out.print("You won the tournament! ");
            System.out.printf("Total raised money: %.2f", totalDaysSum);
        } else {
            System.out.print("You lost the tournament! ");
            System.out.printf("Total raised money: %.2f", totalDaysSum);
        }
        }
    }

