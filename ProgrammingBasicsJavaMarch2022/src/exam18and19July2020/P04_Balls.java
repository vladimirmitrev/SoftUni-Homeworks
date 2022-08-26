package exam18and19July2020;

import java.util.Scanner;

public class P04_Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ballNumber = Integer.parseInt(scanner.nextLine());


        int redBalls = 0;
        int orangeBalls = 0;
        int yellowBalls = 0;
        int whiteBalls = 0;
        int otherBalls = 0;
        int blackBalls = 0;

        double totalPoints = 0;
        double finalPoints = 0;


        for (int i = 1; i <= ballNumber ; i++) {
            String color = scanner.nextLine();

            switch (color) {
                case "red":
                redBalls++;
                totalPoints += 5;
                    break;
                case "orange":
                    orangeBalls++;
                    totalPoints += 10;
                    break;
                case "yellow":
                    yellowBalls++;
                    totalPoints += 15;
                    break;
                case "white":
                    whiteBalls++;
                    totalPoints += 20;
                    break;
                case "black":
                    blackBalls++;
                    totalPoints = Math.floor(totalPoints / 2);
                    break;
                default:
                    otherBalls++;
                    break;

            }

        }
        System.out.printf("Total points: %.0f%n", totalPoints);
        System.out.printf("Red balls: %d%n", redBalls);
        System.out.printf("Orange balls: %d%n", orangeBalls);
        System.out.printf("Yellow balls: %d%n", yellowBalls);
        System.out.printf("White balls: %d%n", whiteBalls);
        System.out.printf("Other colors picked: %d%n", otherBalls);
        System.out.printf("Divides from black balls: %d%n", blackBalls);
    }
}
