package moreExeriseForLoop;

import java.util.Scanner;

public class P05_GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double result = 0;
        double zeroToNine = 0;
        double tenToNineteen = 0;
        double twentyToTwentyNine = 0;
        double thirtyToThirtyNine = 0;
        double fortyToFifty = 0;
        double invalidNumber = 0;

        for (int i = 1; i <=n ; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());

            if (currentNum >= 0 && currentNum <= 9) {
                zeroToNine++;
                result = result + (0.2 * currentNum);
            }
            if (currentNum >= 10 && currentNum <= 19) {
                tenToNineteen++;
                result =  result + (0.3 * currentNum);
            }
            if (currentNum >= 20 && currentNum <= 29) {
                twentyToTwentyNine++;
                result =  result + (0.4 * currentNum);
            }
            if (currentNum >= 30 && currentNum <= 39) {
                thirtyToThirtyNine++;
                result = result + 50;
            } if (currentNum >= 40 && currentNum <= 50) {
                fortyToFifty++;
                result = result + 100;
            } if (currentNum < 0 || currentNum > 50) {
                invalidNumber++;
                result = result / 2;
            }
        }
        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", zeroToNine * 100 / n);
        System.out.printf("From 10 to 19: %.2f%%%n", tenToNineteen * 100 / n);
        System.out.printf("From 20 to 29: %.2f%%%n", twentyToTwentyNine * 100 / n);
        System.out.printf("From 30 to 39: %.2f%%%n", thirtyToThirtyNine * 100 / n);
        System.out.printf("From 40 to 50: %.2f%%%n", fortyToFifty * 100 / n);
        System.out.printf("Invalid numbers: %.2f%%%n", invalidNumber * 100 / n);
    }
}
