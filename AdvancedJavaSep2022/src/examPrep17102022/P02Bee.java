package examPrep17102022;

import java.util.Scanner;

public class P02Bee {
    private static int beeRow = 0;
    private static int beeCol = 0;
    private static int pollinatedFlower = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        readAndFillMatrix(scanner, matrixSize, matrix);

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            matrix[beeRow][beeCol] = '.';
            if(command.equals("up") && beeRow != 0) {
                beeRow--;
            } else if(command.equals("down") && beeRow != matrixSize - 1) {
                beeRow++;
            } else if(command.equals("left") && beeCol != 0) {
                beeCol--;
            } else if (command.equals("right") && beeCol != matrixSize - 1) {
                beeCol++;
            } else {
                System.out.println("The bee got lost!");
                break;
            }

            if(matrix[beeRow][beeCol] == 'f') {
                pollinatedFlower++;
            } else if (matrix[beeRow][beeCol] == 'O') {
                continue;
            }
            matrix[beeRow][beeCol] = 'B';

            command = scanner.nextLine();
        }
        if(pollinatedFlower >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlower);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlower);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void readAndFillMatrix(Scanner scanner, int matrixSize, char[][] matrix) {
        for (int row = 0; row < matrixSize; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < inputRow.length; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }
    }
}
