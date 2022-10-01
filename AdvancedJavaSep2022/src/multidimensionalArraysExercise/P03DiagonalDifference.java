package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int[] inputLine = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = inputLine;
        }
        int firstSum = 0;
        for (int counter = 0; counter < n; counter++) {
            firstSum += matrix[counter][counter];
        }
        int secondSum = 0;

        for (int row = 0, col = n - 1; row < n; row++, col--) {
            secondSum += matrix[row][col];
        }
//        for (int row = 0; row < n; row++) {
//            secondSum += matrix[row][n - 1 - row];
//        }

//        for (int counter = 0; counter < n; counter++) {
//            firstSum += matrix[counter][counter];
//            secondSum += matrix[n - 1 - counter][counter];
//        }
        int absSum = Math.abs(firstSum - secondSum);

        System.out.println(absSum);
    }
}
