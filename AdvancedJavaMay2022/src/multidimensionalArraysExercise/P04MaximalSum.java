package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];


        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = elements;
        }

        int maxSum = Integer.MIN_VALUE;
        int bestStartingRow = -1;
        int bestStartingCol = -1;

        //int[][] result = new int[3][3];

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] +  matrix[row + 1][col + 2] +
                        matrix[row + 2][col] +  matrix[row + 2][col + 1] +  matrix[row + 2][col + 2];

                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    bestStartingRow = row;
                    bestStartingCol = col;

//                    result = new int[][]{
//                            {matrix[row][col], matrix[row][col + 1], matrix[row][col + 2]},
//                            {matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]},
//                            {matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]}
//                    };
                }

            }
        }
        System.out.println("Sum = " + maxSum);

        for (int row = bestStartingRow; row < bestStartingRow + 3 ; row++) {
            for (int col = bestStartingCol; col < bestStartingCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

//        printMatrix(result);

    }

//    private static void printMatrix(int[][] resultMatrix) {
//        for (int row = 0; row < 3; row++) {
//            for (int col = 0; col < 3; col++) {
//                System.out.print(resultMatrix[row][col] + " ");
//            }
//            System.out.println();
//        }
    }

