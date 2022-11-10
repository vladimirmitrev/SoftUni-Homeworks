package exam01_25June2022;

import java.util.Scanner;

public class P02StickyFingers {
    private static int row = 0;
    private static int col = 0;
    private static int totalStolen = 0;
    private static char currentChar;
    private static boolean caught = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int r = 0; r < matrixSize; r++) {
            char[] arr = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[r] = arr;
            for (int c = 0; c < arr.length; c++) {
                char currentChar = arr[c];
                if (currentChar == 'D') {
                    row = r;
                    col = c;
                }
            }
        }
        for (int currentCommand = 0; currentCommand < commands.length; currentCommand++) {
            if(caught) {
                break;
            }
            String commandName = commands[currentCommand];
            if (commandName.equals("up")) {
                moveRobber(matrix, -1, 0);
            } else if (commandName.equals("down")) {
                moveRobber(matrix, +1, 0);
            } else if (commandName.equals("left")) {
                moveRobber(matrix, 0, -1);
            } else if (commandName.equals("right")) {
                moveRobber(matrix, 0, +1);
            }

        }
        if(!caught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalStolen);
        }
        printMatrix(matrixSize, matrix);
    }


    private static void moveRobber(char[][] matrix, int rowMove, int colMove) {
        int nextRow = row + rowMove;
        int nextCol = col + colMove;

        if (!isInBounds(matrix, nextRow, nextCol)) {
            System.out.println("You cannot leave the town, there is police outside!");
        } else {
            currentChar = matrix[nextRow][nextCol];
            if (currentChar == '$') {
                int stolenMoney = nextRow * nextCol;
                totalStolen += stolenMoney;
                System.out.printf("You successfully stole %d$.%n", stolenMoney);

            } else if (currentChar == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolen);
                matrix[row][col] = '+';
                matrix[nextRow][nextCol] = '#';
                caught = true;
                return;
            }
            matrix[row][col] = '+';
            matrix[nextRow][nextCol] = 'D';
            row = nextRow;
            col = nextCol;
        }
    }

    public static void printMatrix(int matrixSize, char[][] matrix) {
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
