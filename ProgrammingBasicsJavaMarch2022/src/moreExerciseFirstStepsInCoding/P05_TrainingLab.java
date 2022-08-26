package moreExerciseFirstStepsInCoding;

import java.util.Scanner;

public class P05_TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double lengthInMeters = Double.parseDouble(scanner.nextLine());
        double widthInMeters = Double.parseDouble(scanner.nextLine());

        double widthInCentimeters = (widthInMeters * 100) - 100;
        double lengthInCentimeteres = lengthInMeters * 100;
        double deskCount = widthInCentimeters / 70;
        double rowsCount = lengthInCentimeteres / 120;
        double deskAll = Math.floor(deskCount);
        double rowsAll = Math.floor(rowsCount);
        double allSeats = deskAll * rowsAll - 3;

        System.out.printf("%.0f", allSeats);
    }
}
