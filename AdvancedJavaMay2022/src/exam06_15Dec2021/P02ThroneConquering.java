package exam06_15Dec2021;

import java.util.Scanner;

public class P02ThroneConquering {
    private static long health = 0;
    private static int parisRow = 0;
    private static int parisCol = 0;

    private static boolean isDead = false;

    private static boolean foundHelen = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long healthStart = Integer.parseInt(scanner.nextLine());

        health = healthStart;

        int numberOfRows = Integer.parseInt(scanner.nextLine());

       // RECTANGULAR NOT SQUARE!!!
        char[][] matrix = new char[numberOfRows][];


        for (int row = 0; row < numberOfRows; row++) {
            char[] input = scanner.nextLine().toCharArray();
            //matrix[row] = new char[input.length];
            matrix[row] = input;
            for (int col = 0; col < input.length; col++) {
                //char currentChar = matrix[row][col];
                if (matrix[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        String input = scanner.nextLine();

        while (true) {

            String[] commandParts = input.split("\\s+");

            String command = commandParts[0];
            int spartanRow = Integer.parseInt(commandParts[1]);
            int spartanCol = Integer.parseInt(commandParts[2]);

            if (command.equals("up")) {
                matrix[spartanRow][spartanCol] = 'S';
                health--;
                moveParis(matrix, -1, 0);
            } else if (command.equals("down")) {
                matrix[spartanRow][spartanCol] = 'S';
                health--;
                moveParis(matrix, +1, 0);
            }  else if (command.equals("left")) {
                matrix[spartanRow][spartanCol] = 'S';
                health--;
                moveParis(matrix, 0, -1);
            }  else if (command.equals("right")) {
                matrix[spartanRow][spartanCol] = 'S';
                health--;
                moveParis(matrix, 0, +1);
            }
            if(foundHelen) {
                break;
            }
            checkHealth(matrix);
            if(isDead) {
                break;
            }
            input = scanner.nextLine();

        }
        printTheMatrix(matrix);
    }

    private static void checkHealth(char[][] matrix) {
        if (health <= 0) {
            matrix[parisRow][parisCol] = 'X';
            isDead = true;
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }
    }

    private static void moveParis(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = parisRow + rowMutator;
        int nextCol = parisCol + colMutator;

        boolean isBonusHit = false;

        if (isInBounds(matrix, nextRow, nextCol)) {
            char nextChar = matrix[nextRow][nextCol];

            if (nextChar == 'S') {
                health -= 2;
                matrix[parisRow][parisCol] = '-';
                matrix[nextRow][nextCol] = 'P';
                parisRow = nextRow;
                parisCol = nextCol;

            } else if (nextChar == 'H') {
                matrix[parisRow][parisCol] = '-';
                matrix[nextRow][nextCol] = '-';
                foundHelen = true;
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", health);
                return;
            } else if (nextChar == '-') {
                matrix[parisRow][parisCol] = '-';
                matrix[nextRow][nextCol] = 'P';
                parisRow = nextRow;
                parisCol = nextCol;
            }
        } else {
            matrix[parisRow][parisCol] = 'P';
            parisRow = parisRow;
            parisCol = parisCol;
        }
    }

    //PRINT RECTANGULAR MATRIX (NOT SQUARE)
    private static void printTheMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
