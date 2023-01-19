package multidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int numberToSearch = Integer.parseInt(scanner.nextLine());

        List<String> outputLines = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == numberToSearch) {
                    outputLines.add(row + " " + col);
                }
            }
        }
        String output = formatOutput(outputLines);

        System.out.println(output);

    }


    private static String formatOutput(List<String> outputLines) {
        if (outputLines.isEmpty()) {
            return "not found";
        }
        return String.join(System.lineSeparator(), outputLines);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] dimensions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
