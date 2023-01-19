package multidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            matrix[row] = input;
        }

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("END")) {
            String[] input = inputLine.split("\\s+");
            String command = input[0];

            if(command.equals("swap") && input.length == 5) {
                int currentRow = Integer.parseInt(input[1]);
                int currentCol = Integer.parseInt(input[2]);
                int newRow = Integer.parseInt(input[3]);
                int newCol = Integer.parseInt(input[4]);

                if(isInBounds(matrix, currentRow, currentCol)) {
                    String temp = matrix[currentRow][currentCol];
                    matrix[currentRow][currentCol] = matrix[newRow][newCol];
                    matrix[newRow][newCol] = temp;
                    printMatrixTemp(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
                }
            else {
                System.out.println("Invalid input!");
            }
            inputLine = scanner.nextLine();
            }
        }

    private static void printMatrixTemp(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static boolean isInBounds(String[][] matrix, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[currentRow].length;
    }

}
