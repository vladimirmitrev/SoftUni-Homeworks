package multidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays
                        .stream(scanner.nextLine().split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int sum = 0;

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays
                            .stream(scanner.nextLine().split(", "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            matrix[row] = arr;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNum = matrix[row][col];
                sum += currentNum;
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
