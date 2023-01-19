package exam05_23Oct2021;

import java.util.Scanner;

public class P02MouseAndCheese {
    private static int mouseRow = 0;
    private static int mouseCol = 0;
    private static int eatenChesses = 0;
    private static boolean isOut = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < matrixSize; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }


        String command = scanner.nextLine();
        while (!command.equals("end")) {

            switch (command) {
                case "up":
                    moveMouse(matrix, -1, 0);
                    break;
                case "down":
                    moveMouse(matrix, 1, 0);
                    break;
                case "left":
                    moveMouse(matrix, 0, -1);
                    break;
                case "right":
                    moveMouse(matrix, 0, 1);
                    break;
            }
            if(isOut) {
                break;
            }
            command = scanner.nextLine();
        }

        if(isOut) {
            System.out.println("Where is the mouse?");
        }

        if(eatenChesses < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenChesses);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenChesses);
        }

        printMatrix(matrix);
    }

    private static void moveMouse(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = mouseRow + rowMutator;
        int nextCol = mouseCol + colMutator;

        if(outOfBounds(matrix, nextRow, nextCol)) {
            matrix[mouseRow][mouseCol] = '-';
            isOut = true;
            return;
        }
        if(matrix[nextRow][nextCol] == 'c') {
            eatenChesses++;
        } else if (matrix[nextRow][nextCol] == 'B') {
            matrix[mouseRow][mouseCol] = '-';
            mouseRow = nextRow;
            mouseCol = nextCol;
            moveMouse(matrix, rowMutator, colMutator);
            return;
        }
        matrix[mouseRow][mouseCol] = '-';
        matrix[nextRow][nextCol] = 'M';
        mouseRow = nextRow;
        mouseCol = nextCol;

    }

    private static boolean outOfBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[nextRow].length;
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
