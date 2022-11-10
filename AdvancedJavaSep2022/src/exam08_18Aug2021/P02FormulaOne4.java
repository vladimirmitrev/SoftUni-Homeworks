package exam08_18Aug2021;

import java.util.Scanner;

public class P02FormulaOne4 {
    private static int playerRow;
    private static int playerCol;
    private static boolean wonRace = false;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        readAndFillMatrix(scanner, size, matrix);

        while(commandsCount-- > 0 && !wonRace) {
            String command = scanner.nextLine();
            switch (command) {

                case "up":
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    movePlayer(matrix, 1, 0);
                    break;
                case "left":
                    movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    movePlayer(matrix, 0, 1);
                    break;
            }
        }
        System.out.println(wonRace ? "Well done, the player won first place!" : "Oh no, the player got lost on the track!");
        printMatixFormula(matrix);
    }

    private static void readAndFillMatrix(Scanner scanner, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < size; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
    }

    private static void movePlayer(char[][] matrix, int rowMut, int colMut) {
        int nextRow = playerRow + rowMut;
        int nextCol = playerCol + colMut;

        if(outOfBounds(matrix, nextRow, nextCol)) {
            if(nextRow < 0 || nextRow >= matrix.length) {
                nextRow = nextRow < 0 ? matrix.length - 1 : 0;
            } else {
                nextCol = nextCol < 0 ? matrix.length - 1 : 0;
            }
        }
        if(matrix[nextRow][nextCol] == 'T') {
            return;
        } else if(matrix[nextRow][nextCol] == 'B') {
            matrix[playerRow][playerCol] = '.';
            playerRow = nextRow;
            playerCol = nextCol;
            movePlayer(matrix, rowMut, colMut);
            return;

        } else if(matrix[nextRow][nextCol] == 'F') {
            wonRace = true;
        }

        if(matrix[playerRow][playerCol] != 'B') {
            matrix[playerRow][playerCol] = '.';
        }

        matrix[nextRow][nextCol] = 'P';
        playerRow = nextRow;
        playerCol = nextCol;

    }

    private static boolean outOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }

    private static void printMatixFormula(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
