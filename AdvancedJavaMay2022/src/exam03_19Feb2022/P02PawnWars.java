package exam03_19Feb2022;

import java.util.Scanner;

public class P02PawnWars {
    private static int whiteRow = 0;
    private static int whiteCol = 0;
    private static int blackRow = 0;
    private static int blackCol = 0;
    private static boolean isHit = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = 8;

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[row] = arr;
            for (int col = 0; col < arr.length; col++) {
                char currentChar = arr[col];
                if(currentChar == 'w') {
                    whiteRow = row;
                    whiteCol = col;
                } else if(currentChar == 'b') {
                    blackRow = row;
                    blackCol = col;
                }
            }
        }

        while(whiteRow != 0 && blackRow != 7 && !isHit) {
            if (whiteHitBlack(whiteRow, whiteCol, blackRow, blackCol)) {

                String coordinates = findCoordinates(blackRow, blackCol);
                System.out.printf("Game over! White capture on %s.", coordinates);
                isHit = true;
            }
            whiteRow -= 1;
            if(blackHitWhite(blackRow, blackCol, whiteRow, whiteCol)) {

                String coordinates = findCoordinates(whiteRow, whiteCol);
                System.out.printf("Game over! Black capture on %s.", coordinates);
                isHit = true;
            }
            blackRow += 1;
        }
        if(!isHit) {
            System.out.print(whiteRow == 0
                            ? "Game over! White pawn is promoted to a queen at " + findCoordinates(whiteRow, whiteCol) + "."
                            : "Game over! Black pawn is promoted to a queen at " + findCoordinates(blackRow, blackCol) + "."
                    );
        }
    }

    private static boolean blackHitWhite(int blackRow, int blackCol, int whiteRow, int whiteCol) {
        if (blackRow + 1 == whiteRow && (blackCol + 1 == whiteCol || blackCol - 1 == whiteCol)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean whiteHitBlack(int whiteRow, int whiteCol, int blackRow, int blackCol) {
        if (whiteRow - 1 == blackRow && (whiteCol + 1 == blackCol || whiteCol - 1 == blackCol)) {
            return true;
        } else {
            return false;
        }
    }
    private static String findCoordinates(int bRow, int bCol) {
        char[] col = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        StringBuilder sb = new StringBuilder();
        sb.append(col[bCol]).append(row[bRow]);
        return sb.toString();
    }
}
