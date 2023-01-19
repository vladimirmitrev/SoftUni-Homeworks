package exam05_23Oct2021;

import java.util.Scanner;

public class P02MouseAndCheese2 {
    private static int mouseRow = 0;
    private static int mouseCol = 0;
    private static int cheeseEaten = 0;
    private static boolean isOut = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < size; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end") && !isOut) {

            matrix[mouseRow][mouseCol] = '-';

            if (command.equals("up") && mouseRow != 0) {
                mouseRow--;
            }  else if (command.equals("down") && mouseRow != matrix.length -1 ) {
                mouseRow++;
            } else if(command.equals("left") && mouseCol != 0) {
                mouseCol--;
            } else if(command.equals("right") && mouseCol != matrix.length - 1) {
                mouseCol++;
            } else {
                isOut = true;
                break;
            }

            if(matrix[mouseRow][mouseCol] == 'c') {
                cheeseEaten++;

            } else if (matrix[mouseRow][mouseCol] == 'B') {
                continue;
            }
            matrix[mouseRow][mouseCol] = 'M';

            command = scanner.nextLine();
        }

        if(isOut) {
            System.out.println("Where is the mouse?");
        }

        if(cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }

        printMatrixMouse(matrix);
    }

    private static void printMatrixMouse(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
