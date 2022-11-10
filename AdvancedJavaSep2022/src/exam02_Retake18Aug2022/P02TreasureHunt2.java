package exam02_Retake18Aug2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt2 {
    private static int playerRow = 0;
    private static int playerCol = 0;
    private static boolean foundTreasure = false;

    private static List<String> listOfCommands = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        //List<String> listOfCommands = new ArrayList<>();

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] inputRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < cols; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'Y') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("Finish")) {

            switch (command) {
                case "up":
                    listOfCommands.add(command);
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    listOfCommands.add(command);
                    movePlayer(matrix, 1, 0);
                    break;
                case "left":
                    listOfCommands.add(command);
                    movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    listOfCommands.add(command);
                    movePlayer(matrix, 0, 1);
                    break;

            }
            command = scanner.nextLine();
        }

        String commands = String.join(", ", listOfCommands);
        System.out.printf(foundTreasure ? "I've found the treasure!%n" + "The right path is " + commands : "The map is fake!");
    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = playerRow + rowMutator;
        int nextCol = playerCol + colMutator;

        if(outOfBounds(matrix, nextRow, nextCol)) {
            listOfCommands.remove(listOfCommands.size() - 1);
            return;
        }
        if(matrix[nextRow][nextCol] == 'T') {
            listOfCommands.remove(listOfCommands.size() - 1);
            foundTreasure = false;
            return;
        } else if (matrix[nextRow][nextCol] == 'X') {
            foundTreasure = true;

        } else if (matrix[nextRow][nextCol] == '-') {
            foundTreasure = false;
        }

        matrix[playerRow][playerCol] = '-';
        matrix[nextRow][nextCol] = 'Y';
        playerRow = nextRow;
        playerCol = nextCol;

    }

    private static boolean outOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
