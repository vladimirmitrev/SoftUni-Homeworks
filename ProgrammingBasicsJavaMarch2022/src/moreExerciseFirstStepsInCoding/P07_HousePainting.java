package moreExerciseFirstStepsInCoding;

import java.util.Scanner;

public class P07_HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double door = 1.2 * 2;
        double windows = (1.5 * 1.5) * 2;
        double houseArea = ((y * x) * 2) + ((x * x) * 2) - door - windows;
        double houseRoof = ((x * y) * 2) + ((x / 2 * h) * 2);
        double greenPaint = houseArea / 3.4;
        double redPaint = houseRoof / 4.3;

        System.out.printf("%.2f%n", greenPaint);
        System.out.printf("%.2f", redPaint);
    }
}
