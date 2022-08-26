package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class P11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snowballCount = Integer.parseInt(scanner.nextLine());

        double highestValue = Double.MIN_VALUE;
        int snowballSnowHighest = 0;
        int snowballTimeHighest = 0;
        int snowballQualityHighest = 0;

        for (int i = 1; i <= snowballCount ; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = Math.pow(1.0 * snowballSnow / snowballTime,snowballQuality);

            if (snowballValue > highestValue) {
               highestValue = snowballValue;
               snowballSnowHighest = snowballSnow;
               snowballTimeHighest = snowballTime;
               snowballQualityHighest = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", snowballSnowHighest, snowballTimeHighest,
                highestValue, snowballQualityHighest );
    }
}
