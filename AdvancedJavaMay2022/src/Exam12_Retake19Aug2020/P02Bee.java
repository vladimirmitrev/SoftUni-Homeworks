package Exam12_Retake19Aug2020;

import java.util.Scanner;

public class P02Bee {
    private static int beeRow;
    private static int beeCol;
    private static boolean isLost = false;
    private static int polinatedFlowers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        readAndFillMatrix(scanner, size, matrix);

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            switch (command) {
                case "up":
                    moveBee(matrix, - 1, 0);
                    break;
                case "down":
                    moveBee(matrix, +1, 0);
                    break;
                case "left":
                    moveBee(matrix, 0, -1);
                    break;
                case "right":
                    moveBee(matrix, 0, +1);
                    break;

            }
            if(isLost) {
                break;
            }

            command = scanner.nextLine();
        }
        if(polinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", polinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - polinatedFlowers);
        }

        printMatrix(matrix);

    }

    private static void moveBee(char[][] matrix, int rowMut, int colMut) {
        int nextRow = beeRow + rowMut;
        int nextCol = beeCol + colMut;

        matrix[beeRow][beeCol] = '.';

        if(outOfBounds(matrix, nextRow, nextCol)) {
            isLost = true;
            System.out.println("The bee got lost!");
            return;
        }
        if(matrix[nextRow][nextCol] == 'f') {
            polinatedFlowers++;
        } else if(matrix[nextRow][nextCol] == 'O') {
            beeRow = nextRow;
            beeCol = nextCol;
            moveBee(matrix, rowMut, colMut);
            return;
        }
        matrix[nextRow][nextCol] = 'B';
        beeRow = nextRow;
        beeCol = nextCol;
    }

    private static void readAndFillMatrix(Scanner scanner, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < size; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    private static boolean outOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }
}
