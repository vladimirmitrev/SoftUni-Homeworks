package exam08_18Aug2021;

import java.util.Scanner;

public class P02FormulaOne {

    private static int playerRow = 0;
    private static int playerCol = 0;
    private static int matrixSizeS = 0;
    private static boolean isFinished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        matrixSizeS = matrixSize;

        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < inputRow.length; col++) {
                char currentChar = matrix[row][col];
                if (currentChar == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    movePlayer(matrix, +1, 0);
                    break;
                case "left":
                    movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    movePlayer(matrix, 0, +1);
                    break;
            }
            if (isFinished) {
                break;
            }
        }

        if (isFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printTheMatrix(matrix);
    }

    private static void printTheMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void movePlayer(char[][] matrix, int rowMut, int colMut) {
        int nextRow = playerRow + rowMut;
        int nextCol = playerCol + colMut;

        boolean isBonusHit = false;

        if (nextRow >= matrixSizeS) {

            matrix[playerRow][playerCol] = '.';
            playerRow = 0;
            matrix[playerRow][playerCol] = 'P';
            return;

        } else if (nextCol >= matrixSizeS) {

            matrix[playerRow][playerCol] = '.';
            playerCol = 0;
            matrix[playerRow][playerCol] = 'P';
            return;

        } else if (nextRow < 0) {

            matrix[playerRow][playerCol] = '.';
            playerRow = matrixSizeS - 1;
            matrix[playerRow][playerCol] = 'P';
            return;

        } else if (nextCol < 0) {

            matrix[playerRow][playerCol] = '.';
            playerCol = matrixSizeS - 1;
            matrix[playerRow][playerCol] = 'P';
            return;
        }

        if (matrix[nextRow][nextCol] == 'F') {

            matrix[playerRow][playerCol] = '.';
            matrix[nextRow][nextCol] = 'P';
            isFinished = true;
            return;
        } else if (matrix[nextRow][nextCol] == 'B') {

            matrix[playerRow][playerCol] = '.';
            matrix[nextRow][nextCol] = 'B';

            matrix[nextRow + rowMut][nextCol + colMut] = 'P';
            playerRow = nextRow + rowMut;
            playerCol = nextCol + colMut;
            if(matrix[playerRow][playerCol] == 'F') {
                isFinished = true;
            }

//            isBonusHit = true;

        }
        else if (matrix[nextRow][nextCol] == 'T') {
            playerRow = nextRow - rowMut;
            playerCol = nextCol - colMut;
        } else {
            matrix[playerRow][playerCol] = '.';
            matrix[nextRow][nextCol] = 'P';
            playerRow = nextRow;
            playerCol = nextCol;
        }

//        if(isBonusHit) {
//            movePlayer(matrix, rowMut, colMut);
//        }

    }
}
