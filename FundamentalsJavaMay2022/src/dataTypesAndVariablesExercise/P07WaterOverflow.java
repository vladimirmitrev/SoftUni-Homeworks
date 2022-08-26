package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int totalLiters = 0;

        for (int i = 1; i <= lines ; i++) {
            int currentLitters = Integer.parseInt(scanner.nextLine());
            totalLiters += currentLitters;

            if (totalLiters > capacity) {
                System.out.println("Insufficient capacity!");
                totalLiters -= currentLitters;
            }

        }
        System.out.println(totalLiters);
    }
}
