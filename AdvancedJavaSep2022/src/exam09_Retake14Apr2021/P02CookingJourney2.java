package exam09_Retake14Apr2021;

import java.util.Scanner;

public class P02CookingJourney2 {
    private static int cookerRow;
    private static int cookerCol;
    private static boolean isOutOfShop = false;
    private static int totalMoney = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < size; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'S') {
                    cookerRow = row;
                    cookerCol = col;
                }
            }
        }
        while (!isOutOfShop && totalMoney < 50) {
                String command = scanner.nextLine();
                switch (command) {
                    case "up":
                        moveCooker(matrix, - 1, 0);
                        break;
                    case "down":
                        moveCooker(matrix, +1, 0);
                        break;
                    case "left":
                        moveCooker(matrix, 0, -1);
                        break;
                    case "right":
                        moveCooker(matrix, 0, +1);
                        break;
                }
        }
        if(isOutOfShop) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", totalMoney);
        printMatrix(matrix);
    }

    private static void moveCooker(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = cookerRow + rowMutator;
        int nextCol = cookerCol + colMutator;

        if(outOfBounds(matrix, nextRow, nextCol)) {
            matrix[cookerRow][cookerCol] = '-';
            isOutOfShop = true;
            return;
        }

        char nextChar = matrix[nextRow][nextCol];

        if(Character.isDigit(nextChar)) {
            totalMoney += Character.getNumericValue(nextChar);
        } else if(nextChar == 'P') {
            matrix[nextRow][nextCol] = '-';
            int[] newPosition = findNewPosition(matrix);
            nextRow = newPosition[0];
            nextCol = newPosition[1];
        }
        matrix[cookerRow][cookerCol] = '-';
        matrix[nextRow][nextCol] = 'S';
        cookerRow = nextRow;
        cookerCol = nextCol;

    }

    private static int[] findNewPosition(char[][] matrix) {
        int[] newPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'P') {
                    newPosition[0] = row;
                    newPosition[1] = col;
                }
            }
        }
        return newPosition;
    }

    private static boolean outOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
