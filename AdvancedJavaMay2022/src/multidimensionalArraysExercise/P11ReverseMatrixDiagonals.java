package multidimensionalArraysExercise;

import java.util.*;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] dimensions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        List<List<Integer>> numbersList = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }

        if (rows == 0) {
            return;
        }
        if (rows == 1) {
            for (int col = cols - 1; col >= 0; col--) {
                System.out.println(matrix[0][col]);
            }
            return;
        }
        for (int k = 0; k <= rows - 1; k++) {
            int i = k;
            int j = 0;

            List<Integer> digits = new ArrayList<>();
            while (i >= 0 && j < cols) {

                digits.add(matrix[i][j]);
                i = i - 1;
                j = j + 1;
            }
            numbersList.add(digits);
        }
        for (int k = 1; k <= cols - 1; k++) {
            int i = rows - 1;
            int j = k;

            List<Integer> digits = new ArrayList<>();
            while (i >= 0 && j < cols) {
                digits.add(matrix[i][j]);
                i = i - 1;
                j = j + 1;
            }
            numbersList.add(digits);
        }
        Collections.reverse(numbersList);
        for (List<Integer> integers : numbersList) {
            System.out.println(integers.toString().replaceAll("[\\[\\],]", ""));

        }
    }
}

