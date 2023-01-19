package Exam14_22Feb2020;

import java.util.Scanner;

public class P02ReVolt {
    private static int playerRow;
    private static int playerCol;

    public static boolean hasWon = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        readAndFillMatrix(scanner, size, matrix);

        //boolean hasWon = false;


        String command = scanner.nextLine();
        while (commandsCount-- > 0 && !hasWon) {

            if(matrix[playerRow][playerCol] != 'B') {
                matrix[playerRow][playerCol] = '-';
            }

            if(command.equals("up")) {
                if(playerRow != 0) {
                    playerRow--;
                } else {
                    playerRow = matrix.length - 1;
                }

            } else if (command.equals("down")) {
                if(playerRow != matrix.length - 1 ) {
                    playerRow++;
                } else {
                    playerRow = 0;
                }
            }  else if (command.equals("left")) {
                if(playerCol != 0) {
                    playerCol--;
                } else {
                    playerCol = matrix.length - 1;
                }

            }  else if (command.equals("right")) {
                if(playerCol != matrix.length - 1) {
                    playerCol++;
                } else {
                    playerCol = 0;
                }
            }

            if(matrix[playerRow][playerCol] == 'T') {
                if(command.equals("up")) {
                    playerRow++;
                } else if(command.equals("down")) {
                    playerRow--;
                } else if (command.equals("left")) {
                    playerCol++;
                } else if (command.equals("right")) {
                    playerCol--;
                }
            } else if(matrix[playerRow][playerCol] == 'B') {
                matrix[playerRow][playerCol] = 'B';
                commandsCount++;
                continue;
            } else if(matrix[playerRow][playerCol] == 'F') {
                hasWon = true;
                matrix[playerRow][playerCol] = 'f';
                break;
            }
            matrix[playerRow][playerCol] = 'f';

            if(commandsCount == 0) {
                break;
            }

            command = scanner.nextLine();

        }
        if(hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void readAndFillMatrix(Scanner scanner, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < size; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
    }
}
