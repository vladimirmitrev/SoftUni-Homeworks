package programming06FundamentalsMidExamRetake;

import java.util.Scanner;

public class P01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalDays = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double currentPlunder = 0;

        for (int day = 1; day <= totalDays ; day++) {
            currentPlunder += dailyPlunder;
            if (day % 3 == 0) {
                currentPlunder = currentPlunder + (dailyPlunder * 0.5);
            }
            if (day % 5 == 0) {
                currentPlunder = currentPlunder * 0.7;
            }
        }
        double percentGot = currentPlunder * 100 / expectedPlunder;
        if (currentPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", currentPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", percentGot);
        }
    }
}
