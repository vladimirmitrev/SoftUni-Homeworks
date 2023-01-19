package exam04_13April2022;

import java.util.Scanner;

public class P02ArmoryAuthor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int[] currPosition = new int[2];
        fillTheMatrix (matrix, size, scanner, currPosition);
        int[] money = new int[1];
        int[] isOut = new int[1];
        int[] areMoneyEnough = new int[1];

        while(true) {
            String direction = scanner.nextLine();
            move(matrix, currPosition, money, direction, isOut, areMoneyEnough);
            if (isOut[0] == 1 || areMoneyEnough[0] == 1){
                break;
            }
        }
        if (isOut[0] == 1) {
            System.out.println("I do not need more swords!");
        }

        if(isOut[0] == 0 && money[0] >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }
//        System.out.printf("Money: %d%n", money[0]);
        System.out.printf("The king paid %d gold coins. %n", money[0]);
        printTheMatrix(matrix);
    }

    private static void printTheMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void move(char[][] matrix, int[] currPosition, int[] money, String direction, int[] isOut, int[] areMoneyEnough) {
        int newRowPosition = 0;
        int newColPosition = 0;
        switch (direction) {
            case "up":
                if (currPosition[0] == 0) {
                    isOut[0] = 1;
                    matrix[currPosition[0]][currPosition[1]] = '-';
                } else {
                    newRowPosition = currPosition[0] - 1;
                }
                newColPosition = currPosition[1];
                break;
            case "down":
                if (currPosition[0] == matrix.length - 1) {
                    isOut[0] = 1;
                    matrix[currPosition[0]][currPosition[1]] = '-';
                } else {
                    newRowPosition = currPosition[0] + 1;
                }
                newColPosition = currPosition[1];
                break;
            case "left":
                if (currPosition[1] == 0) {
                    isOut[0] = 1;
                    matrix[currPosition[0]][currPosition[1]] = '-';
                } else {
                    newColPosition = currPosition[1] - 1;
                }
                newRowPosition = currPosition[0];
                break;
            case "right":
                if (currPosition[1] == matrix.length - 1) {
                    isOut[0] = 1;
                    matrix[currPosition[0]][currPosition[1]] = '-';
                } else {
                    newColPosition = currPosition[1] + 1;
                }
                newRowPosition = currPosition[0];
                break;
        }
        if (isOut[0] == 1) {
            return;
        }
        if (Character.isDigit(matrix[newRowPosition][newColPosition])) {
            money[0] += Character.getNumericValue(matrix[newRowPosition][newColPosition]);
            matrix[currPosition[0]][currPosition[1]] = '-';
            matrix[newRowPosition][newColPosition] = 'A';
            currPosition[0] = newRowPosition;
            currPosition[1] = newColPosition;
        } else if (matrix[newRowPosition][newColPosition] == 'M') {
            matrix[currPosition[0]][currPosition[1]] = '-';
            matrix[newRowPosition][newColPosition] = '-';
            int[] newPosition = findOtherPillar(matrix);
            currPosition[0] = newPosition[0];
            currPosition[1] = newPosition[1];
            matrix[currPosition[0]][currPosition[1]] = 'A';
        } else {
            matrix[currPosition[0]][currPosition[1]] = '-';
            matrix[newRowPosition][newColPosition] = 'A';
            currPosition[0] = newRowPosition;
            currPosition[1] = newColPosition;
        }
        if (money[0] >= 65) {
            areMoneyEnough[0] = 1;
        }
    }

    private static int[] findOtherPillar(char[][] matrix) {
        int[] otherPillarPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currChar = matrix[row][col];
                if (currChar == 'M') {
                    otherPillarPosition[0] = row;
                    otherPillarPosition[1] = col;
                }
            }
        }
        return otherPillarPosition;
    }

    private static void fillTheMatrix(char[][] matrix, int size, Scanner scanner, int[] currPosition) {
        for (int row = 0; row < size; row++) {
            String currLine = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                char currChar = currLine.charAt(col);
                matrix[row][col] = currChar;
                if (currChar == 'A') {
                    currPosition[0] = row;
                    currPosition[1] = col;
                }
            }
        }
    }
}
