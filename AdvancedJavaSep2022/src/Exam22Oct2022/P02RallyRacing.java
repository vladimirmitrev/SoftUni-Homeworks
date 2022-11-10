package Exam22Oct2022;

import java.util.Scanner;

public class P02RallyRacing {
    private static int carRow = 0;
    private static int carCol = 0;
    private static boolean isFinished = false;
    private static int totalKilometers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String carNumber = scanner.nextLine();

        char[][] matrix = new char[size][size];

        fillMatrixRace(scanner, size, matrix);

        String inputCommand = scanner.nextLine();

        matrix[carRow][carCol] = 'C';

        while (!inputCommand.equals("End")) {

            switch (inputCommand) {

                case "up":
                    moveRaceMatrix(matrix, -1, 0);
                    break;
                case "down":
                    moveRaceMatrix(matrix, +1, 0);
                    break;
                case "left":
                    moveRaceMatrix(matrix, 0, -1);
                    break;
                case "right":
                    moveRaceMatrix(matrix, 0, +1);
                    break;
            }
            if (isFinished) {
                break;
            }
            inputCommand = scanner.nextLine();
        }

        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!%n", carNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n", totalKilometers);

        printRaceMatrix(matrix);
    }

    private static void moveRaceMatrix(char[][] matrix, int rowMut, int colMut) {
        int nextRow = carRow + rowMut;
        int nexCol = carCol + colMut;

        matrix[carRow][carCol] = '.';
        totalKilometers += 10;

        if (matrix[nextRow][nexCol] == 'T') {

            matrix[nextRow][nexCol] = '.';

            int[] newPosition = findNewPosition(matrix);

            nextRow = newPosition[0];
            nexCol = newPosition[1];
            totalKilometers += 20;

        } if (matrix[nextRow][nexCol] == 'F') {
            isFinished = true;
        }
        matrix[nextRow][nexCol] = 'C';
        carRow = nextRow;
        carCol = nexCol;
    }

    private static int[] findNewPosition(char[][] matrix) {
        int[] newPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                char currentChar = matrix[row][col];
                if (currentChar == 'T') {
                    newPosition[0] = row;
                    newPosition[1] = col;

                }
            }
        }
        return newPosition;
    }

    private static void fillMatrixRace(Scanner scanner, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            char[] inputRow = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[row] = inputRow;
        }
    }

    private static void printRaceMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char pos : chars) {
                System.out.print(pos);
            }
            System.out.println();
        }
    }
}
