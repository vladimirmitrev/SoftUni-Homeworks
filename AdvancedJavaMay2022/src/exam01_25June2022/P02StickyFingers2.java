package exam01_25June2022;

import java.util.Scanner;

public class P02StickyFingers2 {
    private static int thiefRow = 0;
    private static int thiefCol = 0;
    private static boolean gotCaught = false;
    private static int totalMoney = 0;

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
                if(currentChar == 'D') {
                    thiefRow = row;
                    thiefCol = col;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            matrix[thiefRow][thiefCol] = '+';
            if(commands[i].equals("up") && thiefRow != 0) {
                thiefRow--;
            } else if(commands[i].equals("down") && thiefRow != matrix.length - 1) {
                thiefRow++;

            } else if(commands[i].equals("left") && thiefCol != 0) {
                thiefCol--;
            } else if(commands[i].equals("right") && thiefCol != matrix.length - 1) {
                thiefCol++;
            } else {
                System.out.println("You cannot leave the town, there is police outside!");
                matrix[thiefRow][thiefCol] = 'D';
            }
            if(matrix[thiefRow][thiefCol] == '$') {
                int currentStole = thiefRow * thiefCol;
                System.out.printf("You successfully stole %d$.%n", currentStole);
                totalMoney += currentStole;
            } else if(matrix[thiefRow][thiefCol] == 'P') {
                matrix[thiefRow][thiefCol] = '#';
                gotCaught = true;
                break;
            }
            matrix[thiefRow][thiefCol] = 'D';
        }
        if(gotCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
