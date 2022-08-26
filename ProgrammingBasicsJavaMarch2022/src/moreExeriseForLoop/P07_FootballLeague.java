package moreExeriseForLoop;

import java.util.Scanner;

public class P07_FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int totalFans = Integer.parseInt(scanner.nextLine());
        double aFans = 0;
        double bFans = 0;
        double vFans = 0;
        double gFans = 0;

        for (int i = 1; i <= totalFans ; i++) {
            String input = scanner.nextLine();
            if (input.equals("A")) {
                aFans++;
            } else if (input.equals("B")) {
                bFans++;
            } else if (input.equals("V")) {
                vFans++;
            } else if (input.equals("G")) {
                gFans++;
            }
        }
        System.out.printf("%.2f%%%n", aFans * 100 / totalFans);
        System.out.printf("%.2f%%%n", bFans * 100 / totalFans);
        System.out.printf("%.2f%%%n", vFans * 100 / totalFans);
        System.out.printf("%.2f%%%n", gFans * 100 / totalFans);
        System.out.printf("%.2f%%%n", totalFans * 1.0 * 100 / capacity * 1.0);
    }
}
