package exam04_13April2022;

import java.util.Scanner;

public class P02Armory {
    private static int armyRow = 0;
    private static int armyCol = 0;
    private static int goldCoins = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[row] = arr;
            for (int col = 0; col < arr.length; col++) {
                char currentChar = arr[col];
                if (currentChar == 'A') {
                    armyRow = row;
                    armyCol = col;
                }
            }
        }
        String command = scanner.nextLine();

        while (isInBounds(matrix, armyRow, armyCol) && goldCoins < 65) {
            switch (command) {
                case "up":
                    moveArmy(matrix, -1, 0);
                    break;
                case "down":
                    moveArmy(matrix, +1, 0);
                    break;
                case "left":
                    moveArmy(matrix, 0, -1);
                    break;
                case "right":
                    moveArmy(matrix, 0, +1);
                    break;

            }
            if (!isInBounds(matrix, armyRow, armyCol)) {
                System.out.println("I do not need more swords!");
                break;
            }
            if (goldCoins >= 65) {
                System.out.println("Very nice swords, I will come back for more!");
                break;

            }
            command = scanner.nextLine();
        }

        System.out.printf("The king paid %d gold coins.%n", goldCoins);
        printTheMatrix(matrix);
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void moveArmy(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = armyRow + rowMutator;
        int nextCol = armyCol + colMutator;

        boolean isBonusHit = false;

        if (isInBounds(matrix, nextRow, nextCol)) {
            if (Character.isDigit(matrix[nextRow][nextCol])) {
                goldCoins += Character.getNumericValue(matrix[nextRow][nextCol]);
                matrix[armyRow][armyCol] = '-';
                matrix[nextRow][nextCol] = 'A';
                armyRow = nextRow;
                armyCol = nextCol;

            } else if (matrix[nextRow][nextCol] == 'M') {
                matrix[armyRow][armyCol] = '-';
                matrix[nextRow][nextCol] = '-';
                int newRow = findOtherMirrorRow(matrix, armyRow);
                int newCol = findOtherMirrorCol(matrix, armyCol);
                armyRow = newRow;
                armyCol = newCol;
                matrix[armyRow][armyCol] = 'A';
            } else {
                matrix[armyRow][armyCol] = '-';
                matrix[nextRow][nextCol] = 'A';
                armyRow = nextRow;
                armyCol = nextCol;
            }
        } else {
            matrix[armyRow][armyCol] = '-';
            armyRow = nextRow;
            armyCol = nextCol;
        }
    }

    private static int findOtherMirrorRow(char[][] matrix, int rowOut) {
        int newRow = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'M') {
                    newRow = row;
                }
            }
        }
        return newRow;
    }

    private static int findOtherMirrorCol(char[][] matrix, int colOut) {
        int newCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'M') {
                    newCol = col;
                }
            }
        }
        return newCol;
    }

    private static void printTheMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}
