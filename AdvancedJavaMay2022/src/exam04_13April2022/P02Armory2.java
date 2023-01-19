package exam04_13April2022;

import java.util.Scanner;

public class P02Armory2 {
    private static int soldierRow = 0;
    private static int soldierCol = 0;
    private static boolean isOut = false;
    private static int totalBlades = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        readAndFillMatrix(scanner, size, matrix);


        while (totalBlades < 65 && !isOut) {
            String command = scanner.nextLine();
            matrix[soldierRow][soldierCol] = '-';
            if (command.equals("up") && soldierRow != 0) {
                soldierRow--;
            } else if (command.equals("down") && soldierRow != matrix.length - 1) {
                soldierRow++;
            } else if (command.equals("left") && soldierCol != 0) {
                soldierCol--;
            } else if (command.equals("right") && soldierCol != matrix.length - 1) {
                soldierCol++;
            } else {
                System.out.println("I do not need more swords!");
                isOut = true;
                break;
            }
            if(Character.isDigit(matrix[soldierRow][soldierCol])) {
            totalBlades += Character.getNumericValue(matrix[soldierRow][soldierCol]);
                matrix[soldierRow][soldierCol] = 'A';
            } else if (matrix[soldierRow][soldierCol] == 'M') {
                matrix[soldierRow][soldierCol] = '-';
                int[]  newPosition = findMirror(matrix);
                soldierRow = newPosition[0];
                soldierCol = newPosition[1];
                matrix[soldierRow][soldierCol] = 'A';
            }
            matrix[soldierRow][soldierCol] = 'A';

        }

        if(totalBlades >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", totalBlades);

        printMatrix(matrix);
    }

    private static int[] findMirror(char[][] matrix) {
        int[] newPosition = new int [2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'M') {
                    newPosition[0] = row;
                    newPosition[1] = col;
                }
            }
        }
        return newPosition;
    }

    private static void readAndFillMatrix(Scanner scanner, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < size; col++) {
                char currentChar = matrix[row][col];
                if (currentChar == 'A') {
                    soldierRow = row;
                    soldierCol = col;
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
}
