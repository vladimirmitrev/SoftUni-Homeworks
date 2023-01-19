package multidimensionalArraysExercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);

        String type = input[1];

        int[][] matrix = new int[n][n];

        if (type.equals("A")) {
            fillMatrixA(n, matrix);

        } else if (type.equals("B")) {
            fillMatrixB(n, matrix);
        }

        printMatrix(n, matrix);

    }

    private static void printMatrix(int n, int[][] matrix) {
        for (int[] arr : matrix) {
            for (int ints : arr) {
                System.out.print(ints + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixB(int n, int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < n; col++) {
            if(col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = n - 1; row >= 0 ; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }

        }
    }

    private static void fillMatrixA(int n, int[][] matrix) {
        int counter = 1;

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }

    }
}
