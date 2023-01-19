package exam10_20Feb2021;

import java.util.Scanner;

public class P02Bomb3 {
    private static int sapperRow;
    private static int sapperCol;
    private static boolean endGame = false;
    private static int totalBombs = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            char[] inputRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < size; col++) {
                char currentChar = matrix[row][col];
                if (currentChar == 's') {
                    sapperRow = row;
                    sapperCol = col;
                } else if (currentChar == 'B') {
                    totalBombs++;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command) {
                case "up":
                    moveSapper(matrix, -1, 0);
                    break;
                case "down":
                    moveSapper(matrix, +1, 0);
                    break;
                case "left":
                    moveSapper(matrix, 0, -1);
                    break;
                case "right":
                    moveSapper(matrix, 0, +1);
                    break;
            }
            if (endGame) {
                break;
            }
            if (totalBombs == 0) {
                break;
            }
        }
        if (totalBombs == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (endGame) {
            System.out.printf("END! %d bombs left on the field", totalBombs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", totalBombs, sapperRow, sapperCol);
        }

    }

    private static void moveSapper(char[][] matrix, int rowMut, int colMut) {
        int nextRow = sapperRow + rowMut;
        int nextCol = sapperCol + colMut;

        if (outOfBounds(matrix, nextRow, nextCol)) {
            return;
        }
        if (matrix[nextRow][nextCol] == 'B') {
            System.out.println("You found a bomb!");
            totalBombs--;
        } else if (matrix[nextRow][nextCol] == 'e') {
            endGame = true;
        }
        matrix[sapperRow][sapperCol] = '+';
        matrix[nextRow][nextCol] = 's';
        sapperRow = nextRow;
        sapperCol = nextCol;

    }

    private static boolean outOfBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix.length;
    }
}
