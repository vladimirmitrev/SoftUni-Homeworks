package exam03_19Feb2022;

import java.util.Scanner;

public class P02PawnWars2 {
    private static int whiteRow = 0;
    private static int whiteCol = 0;
    private static int blackRow = 0;
    private static int blackCol = 0;
    private static boolean captured = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int size = 8;
        
        char[][] matrix = new char[8][8];

        String coordinates = "";

        for (int row = 0; row < matrix.length; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < matrix.length; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'w') {
                    whiteRow = row;
                    whiteCol = col;
                } else if (currentChar == 'b') {
                    blackRow = row;
                    blackCol = col;
                }
            }
        }
        while (whiteRow > 0 && blackRow < matrix.length - 1 && !captured) {
            if(whiteRow - 1 == blackRow & (whiteCol + 1 == blackCol || whiteCol - 1 == blackCol)) {
                captured = true;
                coordinates = findCoordinates(blackRow, blackCol );
                System.out.printf("Game over! White capture on %s.", coordinates);
                break;
            }
            whiteRow--;
            if(blackRow + 1 == whiteRow & (blackCol + 1 == whiteCol || blackCol - 1 == whiteCol)) {
                captured = true;
                coordinates = findCoordinates(whiteRow, whiteCol);
                System.out.printf("Game over! Black capture on %s.", coordinates);
            }
            blackRow++;
        }
        if(!captured) {
            System.out.print(whiteRow == 0
                    ? "Game over! White pawn is promoted to a queen at "
                    + findCoordinates(whiteRow, whiteCol) + "."
                    : "Game over! Black pawn is promoted to a queen at "
                            + findCoordinates(blackRow, blackCol) + ".");

        }
    }

    private static String findCoordinates(int currentRow, int currentCol) {
        char[] col = new char[]{'a','b','c','d','e','f','g','h'};
        char[] row = new char[]{'8','7','6','5','4','3','2','1'};
        StringBuilder sb = new StringBuilder();
        sb.append(col[currentCol]).append(row[currentRow]);

        return sb.toString();
    }
}
