package multidimensionalArraysLab;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = readMatrix(scanner);
        findQueen(matrix);

    }

    private static void findQueen(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (checkCurrentChar(matrix, i, j, matrix[i][j])) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    private static boolean checkCurrentChar(char[][] matrix, int i, int j, char current) {
        return checkRow(matrix, i, j, current) && checkCol(matrix, i, j, current) && checkDiagonals(matrix, i, j, current);

    }

    private static boolean checkDiagonals(char[][] matrix, int i, int j, char current) {
        int row = i + 1, col = j + 1;
        while (row < matrix.length && col < matrix[row].length) {
            if (matrix[row++][col++] == current) {
                return false;
            }
        }
        row = i - 1;
        col = j - 1;
        while (row >= 0 && col >= 0) {
            if (matrix[row--][col--] == current) {
                return false;
            }
        }
        row = i - 1;
        col = j + 1;
        while (row >= 0 && col < matrix[row].length) {
            if (matrix[row--][col++] == current) {
                return false;
            }
        }
        row = i + 1;
        col = j - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row++][col--] == current) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(char[][] matrix, int i, int j, char current) {
        if (i > 0) {
            for (int k = 0; k < i; k++) {
                if (matrix[k][j] == current) {
                    return false;
                }
            }
        }
        if (i + 1 < matrix.length) {
            for (int k = i + 1; k < matrix.length; k++) {
                if (matrix[k][j] == current) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRow(char[][] matrix, int i, int j, char current) {
        if (j > 0) {
            for (int k = 0; k < j; k++) {
                if (matrix[i][k] == current) {
                    return false;
                }
            }
        }
        if (j + 1 < matrix[i].length) {
            for (int k = j + 1; k < matrix[i].length; k++) {
                if (matrix[i][k] == current) {
                    return false;
                }
            }
        }
        return true;
    }

    private static char[][] readMatrix(Scanner scan) {
        char[][] matrix = new char[8][8];
        for (int row = 0; row < 8; row++) {
            matrix[row] = readArray(scan);
        }
        return matrix;
    }

    private static char[] readArray(Scanner scan) {
        return scan.nextLine()
                .replaceAll("\\s+", "").toCharArray();

    }
}
