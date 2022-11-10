package examOthers;

import java.util.Arrays;
import java.util.Scanner;

public class P02Garden {
    private static int[][] matrix;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        fillMatrix(dimensions[0], dimensions[1]);
        String input;

        while (!"Bloom Bloom Plow".equals(input = scanner.nextLine())) {

            int[] index = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (isValidIndexes(index[0], index[1])) {
                bloomFlowers(index[0], index[1]);
            } else {
                System.out.println("Invalid coordinates.");
            }
        }
        printMatrix();
    }

    private static boolean isValidIndexes(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void bloomFlowers(int row, int col) {
        int i = row;
        while (isValidIndexes(i, col)) {
            matrix[i][col]++;
            i++;
        }
        i = row-1;
        while (isValidIndexes(i, col)) {
            matrix[i][col]++;
            i--;
        }
        int j = col+1;
        while (isValidIndexes(row, j)) {
            matrix[row][j]++;
            j++;
        }
        j = col-1;
        while (isValidIndexes(row, j)) {
            matrix[row][j]++;
            j--;
        }
    }

    private static void fillMatrix(int row, int col) {
        matrix = new int[row][col];
        for (int[] ints : matrix) {
            Arrays.fill(ints, 0);
        }
    }

    private static void printMatrix() {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", " ")).forEach(System.out::println);
    }

}
