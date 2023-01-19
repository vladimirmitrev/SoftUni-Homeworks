package exam09_Retake14Apr2021;

import java.util.Scanner;

public class P02CookingJourney {
    private static int sRow = 0;
    private static int sCol = 0;

    private static int totalMoney = 0;

    private static boolean inField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < inputRow.length; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'S') {
                    sRow = row;
                    sCol = col;
                }
            }
        }
        while (inField && totalMoney < 50) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    moveMatrix(matrix, -1, 0);
                    break;
                case "down":
                    moveMatrix(matrix, +1, 0);
                    break;
                case "left":
                    moveMatrix(matrix, 0, -1);
                    break;
                case "right":
                    moveMatrix(matrix, 0, +1);
                    break;
            }


        }
        if(!inField) {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        if(totalMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", totalMoney);
        printMatrix(matrix);
    }

    private static void moveMatrix(char[][] matrix, int rowMut, int colMut) {
        int nextRow = sRow + rowMut;
        int nextCol = sCol + colMut;

        if (isInBounds(matrix, nextRow, nextCol)) {
            if(Character.isDigit(matrix[nextRow][nextCol])) {
                totalMoney += Character.getNumericValue(matrix[nextRow][nextCol]);
                matrix[sRow][sCol] = '-';
                matrix[nextRow][nextCol] = 'S';
                sRow = nextRow;
                sCol = nextCol;

            } else if(matrix[nextRow][nextCol] == 'P') {
                matrix[sRow][sCol] = '-';
                matrix[nextRow][nextCol] = '-';
                int[] newPosition = findOtherPillar(matrix);
                nextRow = newPosition[0];
                nextCol = newPosition[1];
                matrix[nextRow][nextCol] = 'S';
                sRow = nextRow;
                sCol = nextCol;

            } else {
                matrix[sRow][sCol] = '-';
                matrix[nextRow][nextCol] = 'S';
                sRow = nextRow;
                sCol = nextCol;
            }
        } else {
           matrix[sRow][sCol] = '-';
            inField = false;
        }


    }
    private static int[] findOtherPillar(char[][] matrix) {
        int[] otherPillarPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'P') {
                    otherPillarPosition[0] = row;
                    otherPillarPosition[1] = col;
                }
            }
        }
        return otherPillarPosition;
    }


    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
