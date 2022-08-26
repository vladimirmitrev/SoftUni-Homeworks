package exam6and7July2019;

import java.util.Scanner;

public class P06_NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int maxScore = 0;
        String winnerName = "";

        while (!name.equals("Stop")) {
            int currentScore = 0;
            for (int i = 0; i < name.length() ; i++) {

                char charLetter = name.charAt(i);

                int number = Integer.parseInt(scanner.nextLine());


                if (charLetter == number) {
                    currentScore = currentScore + 10;
                } else {
                    currentScore = currentScore + 2;
                }

            }
            if (currentScore >= maxScore) {
                maxScore = currentScore;
                winnerName = name;
            }
            name = scanner.nextLine();


        }
        System.out.printf("The winner is %s with %d points!%n", winnerName, maxScore);

        }
    }

