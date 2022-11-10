package exam10_20Feb2021;

import java.util.Scanner;

public class P02Bomb {
    private static int sapRow = 0;
    private static int sapCol = 0;

    private static int totalBombs = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[] commandParts = scanner.nextLine().split(",");

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            char[] inputRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < inputRow.length; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 's') {
                    sapRow = row;
                    sapCol = col;
                } else if (currentChar == 'B') {
                    totalBombs++;
                }
                //matrix[row][col] == currentChar;
            }
        }
        int foundBombs = 0;
        for (int i = 0; i < commandParts.length; i++) {
            String command = commandParts[i];
            if(command.equals("up")) {
                if(sapRow > 0) {
                    sapRow -= 1;
                }
            } else if(command.equals("down")) {
                if(sapRow < matrixSize - 1) {
                    sapRow += 1;
                }
            } else if(command.equals("left")) {
                if(sapCol > 0) {
                    sapCol -= 1;
                }
            } else if(command.equals("right")){
                if(sapCol < matrixSize - 1) {
                    sapCol += 1;
                }
            }
            if(matrix[sapRow][sapCol] == 'B') {
                System.out.println("You found a bomb!");
                foundBombs++;
                matrix[sapRow][sapCol] = '-';
                if(foundBombs == totalBombs) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[sapRow][sapCol] == 'e') {
                System.out.printf("END! %d bombs left on the field", totalBombs - foundBombs);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", totalBombs - foundBombs, sapRow, sapCol );
    }
}
