package moreExercisesConditionalStatements;

import java.util.Scanner;

public class P04_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int kilometers = Integer.parseInt(scanner.nextLine());
            String timeOfDay = scanner.nextLine();

            double taxiDayPrice = 0.7 + 0.79 * kilometers;
            double taxiNightPrice = 0.7 + 0.90 * kilometers;
            double busPrice = 0.09 * kilometers;
            double trainPrice = 0.06 * kilometers;

            if (kilometers < 20 && timeOfDay.equals("day")) {
                System.out.printf("%.2f", taxiDayPrice);
            } else if (kilometers < 20 && timeOfDay.equals("night")) {
                System.out.printf("%.2f", taxiNightPrice);
            } else if (kilometers >= 20 && kilometers < 100) {
                System.out.printf("%.2f", busPrice);
            } else {
                System.out.printf("%.2f", trainPrice);
            }
    }
}
