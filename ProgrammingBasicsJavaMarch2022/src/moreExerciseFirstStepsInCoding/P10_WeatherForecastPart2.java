package moreExerciseFirstStepsInCoding;

import java.util.Scanner;

public class P10_WeatherForecastPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        if (input >= 5 && input <= 11.9) {
            System.out.println("Cold");
        } else if (input >= 12 && input <= 14.9) {
            System.out.println("Cool");
        } else if (input >= 15 && input <= 20) {
            System.out.println("Mild");
        } else if (input >= 20.1 && input <= 25.9) {
            System.out.println("Warm");
        } else if (input >= 26 && input <= 35) {
            System.out.println("Hot");
        } else {
            System.out.println("unknown");
        }
    }
}
