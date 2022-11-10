package Exam13_28June2020;

import java.util.Scanner;

public class P02Snake {
    private static int snakeRow = 0;
    private static int snakeCol = 0;
    private static boolean hasWon = false;
    private static boolean isOutOfBounds = false;
    private static int foodEaten = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < inputRow.length; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                }
            }
        }

        while (!isOutOfBounds && !hasWon) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    moveSnake(matrix, -1 ,0);
                    break;
                case "down":
                    moveSnake(matrix, +1, 0);
                    break;
                case "left":
                    moveSnake(matrix, 0, -1);
                    break;
                case "right":
                    moveSnake(matrix, 0, +1);
                    break;

            }

        }
        if(isOutOfBounds) {
            System.out.println("Game over!");
        }
        if(hasWon) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", foodEaten);
        printMatrix(matrix);

    }

    private static void moveSnake(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = snakeRow + rowMutator;
        int nextCol = snakeCol + colMutator;

        if(isOutOfBounds(matrix, nextRow, nextCol)) {
            isOutOfBounds = true;
            matrix[snakeRow][snakeCol] = '.';
            return;
        }
        if(matrix[nextRow][nextCol] == '*') {
            foodEaten++;
            if(foodEaten == 10) {
                hasWon = true;
            }

        } else if (matrix[nextRow][nextCol] == 'B') {
           // matrix[snakeRow][snakeCol] = '.';
            matrix[nextRow][nextCol] = '.';
            int[] newPosition = findOtherB(matrix);
            nextRow = newPosition[0];
            nextCol = newPosition[1];
        }

        matrix[snakeRow][snakeCol] = '.';
        matrix[nextRow][nextCol] = 'S';
        snakeRow = nextRow;
        snakeCol = nextCol;
    }

    private static int[] findOtherB(char[][] matrix) {
        int[] findBurrow = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'B') {
                    findBurrow[0] = row;
                    findBurrow[1] = col;
                }
            }
        }
        return findBurrow;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
