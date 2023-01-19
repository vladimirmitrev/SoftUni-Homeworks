package exam07_26June2021;

import java.util.Scanner;

public class P02Python {

    private static int snakeLength = 1;
    private static int snakeRow = 0;
    private static int snakeCol = 0;
    private static int totalFood = 0;
    private static boolean snakeKilled = false;
    private static int screenSize = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        screenSize = matrixSize;

        char[][] matrix = new char[matrixSize][matrixSize];


        String[] commandParts = scanner.nextLine().split(", ");

        for (int row = 0; row < matrixSize; row++) {
            char[] inputRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < inputRow.length; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 's') {
                    snakeRow = row;
                    snakeCol = col;
                } else if(currentChar == 'f') {
                    totalFood++;
                }
            }
        }
        for (int i = 0; i < commandParts.length; i++) {
            String command = commandParts[i];
            switch (command) {
                case "up":
                    moveSnake(matrix, -1, 0);
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
            if(totalFood == 0) {
                break;
            }
            if(snakeKilled) {
                break;
            }

        }
        if(totalFood == 0 && !snakeKilled) {
            System.out.printf("You win! Final python length is %d", snakeLength);
        } else if(totalFood > 0 && !snakeKilled) {
            System.out.printf("You lose! There is still %d food to be eaten.", totalFood);
        } else if(snakeKilled) {
            System.out.println("You lose! Killed by an enemy!");
        }

    }

    private static void moveSnake(char[][] matrix, int rowMut, int colMut) {
        int nextRow = snakeRow + rowMut;
        int nextCol = snakeCol + colMut;

        if(nextRow == screenSize) {
            nextRow = 0;
        } else if (nextCol == screenSize) {
            nextCol = 0;
        } else if (nextRow == -1) {
            nextRow = screenSize - 1;
        } else if (nextCol == -1) {
            nextCol = screenSize - 1;
        }

        if (matrix[nextRow][nextCol] == 'f') {
            snakeLength++;
            totalFood--;
            matrix[snakeRow][snakeCol] = '*';
            matrix[nextRow][nextCol] = 's';
        } else if (matrix[nextRow][nextCol] == 'e') {
            snakeKilled = true;
            return;
        }
        snakeRow = nextRow;
        snakeCol = nextCol;
//        else if(matrix[nextRow][nextCol] == '*') {
//            matrix[snakeRow][snakeCol] = '*';
//            matrix[nextRow][nextCol] = 's';
//        }

    }

}
