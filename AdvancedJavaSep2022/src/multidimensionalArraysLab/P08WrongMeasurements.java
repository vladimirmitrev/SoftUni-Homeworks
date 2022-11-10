package multidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, n);
        int[] indexes = readArray(scanner);
        int wrongValue = matrix[indexes[0]][indexes[1]];
        ArrayList<int[]> fixInfo = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    int rightValue = calculateRightValue(matrix, row, col, wrongValue);
                    fixInfo.add(new int[]{row, col, rightValue});
                }
            }
        }
        for (int[] info : fixInfo) {
            matrix[info[0]][info[1]] = info[2];
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            Arrays.stream(ints).mapToObj(anInt -> anInt + " ").forEach(System.out::print);
            System.out.println();
        }
    }

    private static int calculateRightValue(int[][] matrix, int row, int col, int wrongValue) {
        int rightValue = 0;
        if (indexesIsValid(matrix, row, col + 1) && matrix[row][col + 1] != wrongValue) {
            rightValue += matrix[row][col + 1];
        }
        if (indexesIsValid(matrix, row, col - 1) && matrix[row][col - 1] != wrongValue) {
            rightValue += matrix[row][col - 1];
        }
        if (indexesIsValid(matrix, row + 1, col) && matrix[row + 1][col] != wrongValue) {
            rightValue += matrix[row + 1][col];
        }
        if (indexesIsValid(matrix, row-1, col ) && matrix[row - 1][col] != wrongValue) {
            rightValue += matrix[row - 1][col];
        }
        return rightValue;
    }

    private static boolean indexesIsValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[][] readMatrix(Scanner scan, int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = readArray(scan);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
