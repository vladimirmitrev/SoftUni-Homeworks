package exam06_15Dec2021;

import java.util.Scanner;

public class P02ThroneConquering2 {
    private static int parisRow = 0;
    private static int parisCol = 0;
    private static int currentHealth = 0;

    private static boolean isDead = false;
    private static boolean foundHelen = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHealth = Integer.parseInt(scanner.nextLine());

        currentHealth = initialHealth;

        int rowSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rowSize][];

        for (int row = 0; row < rowSize; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < inputRow.length; col++) {
                char currentChar = matrix[row][col];
                if (currentChar == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }
        while (currentHealth > 0 && !foundHelen) {

            String[] commandParts = scanner.nextLine().split(" ");
            String command = commandParts[0];
            int spartanRow = Integer.parseInt(commandParts[1]);
            int spartanCol = Integer.parseInt(commandParts[2]);

            matrix[spartanRow][spartanCol] = 'S';
            matrix[parisRow][parisCol] = '-';
            currentHealth--;

            if (command.equals("up") && parisRow != 0) {
                parisRow--;
            } else if (command.equals("down") && parisRow != matrix.length - 1) {
                parisRow++;
            } else if (command.equals("left") && parisCol != 0) {
                parisCol--;
            } else if (command.equals("right") && parisCol != matrix.length - 1) {
                parisCol++;
            } else {
                matrix[parisRow][parisCol] = 'P';
            }
            if (matrix[parisRow][parisCol] == 'S') {
                currentHealth -= 2;
            } else if ((matrix[parisRow][parisCol] == 'H')) {
                matrix[parisRow][parisCol] = '-';
                foundHelen = true;
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", currentHealth);
                break;
            }
            matrix[parisRow][parisCol] = 'P';

            if (currentHealth <= 0) {
                isDead = true;
                matrix[parisRow][parisCol] = 'X';
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                break;
            }

        }

        printMatix(matrix);

    }

    private static void printMatix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
