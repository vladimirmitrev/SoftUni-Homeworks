package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSizes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixSizes[0];
        int cols = matrixSizes[1];

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] inputRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < cols; col++) {

            }
        }
        char newColor = scanner.nextLine().charAt(0);

        int[] clickedPixels = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int clickedRow = clickedPixels[0];
        int clickedCol = clickedPixels[1];

        char oldColor = matrix[clickedRow][clickedCol];

        paint(matrix, newColor, oldColor, clickedRow, clickedCol);

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void paint(char[][] matrix, char newColor, char oldColor, int clickedRow, int clickedCol) {

        if(isOutOfBounds(matrix, clickedRow, clickedCol)) {
            return;
        } else if(matrix[clickedRow][clickedCol] != oldColor) {
            return;
        }

        matrix[clickedRow][clickedCol] = newColor;

        paint(matrix, newColor, oldColor, clickedRow - 1, clickedCol);
        paint(matrix, newColor, oldColor, clickedRow + 1, clickedCol);
        paint(matrix, newColor, oldColor, clickedRow, clickedCol - 1);
        paint(matrix, newColor, oldColor, clickedRow, clickedCol + 1);


    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
