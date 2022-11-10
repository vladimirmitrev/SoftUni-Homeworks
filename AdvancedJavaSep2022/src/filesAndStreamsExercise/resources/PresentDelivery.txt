package exam15_Retake17Dec2019;

import java.util.Scanner;


public class P02PresentDelivery {
    private static int santaRow = 0;
    private static int santaCol = 0;
    private static int presentsGave = 0;
    private static int niceKids = 0;
    private static int presents;

    private static char[][] matrix;



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        presents = Integer.parseInt(scanner.nextLine());

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            char[] arr = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = arr;
            for (int j = 0; j < arr.length; j++) {
                char currentChar = arr[j];
                if(currentChar == 'S') {
                    santaRow = i;
                    santaCol = j;
                } else if (currentChar == 'V') {
                    niceKids++;
                }
            }
        }

        String command;

        while ((isInBounds(matrix,santaRow, santaCol) && presents > 0) && !"Christmas morning".equals(command = scanner.nextLine())) {

            switch (command) {

                case "up":
                    moveSanta(matrix, -1, 0);
                    break;
                case "down":
                    moveSanta(matrix, +1, 0);
                    break;
                case "left":
                    moveSanta(matrix, 0, -1);
                    break;
                case "right":
                    moveSanta(matrix, 0, +1);
                    break;
                default:
                    return;

            }
        }

        if(presents == 0 || !isInBounds(matrix, santaRow, santaCol)) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrixSize, matrix);
        if(presentsGave >= niceKids) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", niceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.",  niceKids - presentsGave);
        }

    }

    private static void printMatrix(int matrixSize, char[][] matrix) {
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
    private static void moveSanta(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = santaRow + rowMutator;
        int nextCol = santaCol + colMutator;


        if(isInBounds(matrix, santaRow, santaCol)) {
            char currentChar = matrix[nextRow][nextCol];
            if (currentChar == 'V') {
                presentsGave++;
                presents--;
            } else if(currentChar == 'C') {
                position(santaRow - 1, santaCol);
                position(santaRow + 1, santaCol);
                position(santaRow, santaCol - 1);
                position(santaRow, santaCol + 1);
            }
        }
        matrix[santaRow][santaCol] = '-';
        matrix[nextRow][nextCol] = 'S';
        santaRow = nextRow;
        santaCol = nextCol;

    }

    private static void position(int row, int col) {
        if(matrix[row][col] == 'V' || matrix[row][col] == 'X') {
            presents--;
            if(matrix[row][col] == 'V') {
                presentsGave++;
            }
            matrix[row][col] = '-';
        }
    }
}
