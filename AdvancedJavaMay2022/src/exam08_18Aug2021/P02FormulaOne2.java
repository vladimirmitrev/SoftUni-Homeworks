package exam08_18Aug2021;

import java.io.IOException;
import java.util.*;

public class P02FormulaOne2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int commandsCount = Integer.parseInt(scanner.nextLine());


        String[][] matrix = new String[n][n];
        int startRow = 0;
        int startCol = 0;

        boolean hasWon = false;

        for (int i = 0; i < matrix.length ; i++) {
            String[] rows = scanner.nextLine().split("");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rows[j];

                if (matrix[i][j].equals("P")){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        matrix[startRow][startCol] = ".";
        String command = scanner.nextLine();

        for (int i = 0; i < commandsCount ; i++) {
            int preciousRow = startRow;
            int previousCol = startCol;
            String field;


            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0){
                        startRow = matrix.length-1;
                    }

                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length-1){
                        startRow = 0;
                    }
                    break;

                case "left":
                    startCol--;
                    if (startCol < 0){
                        startCol = matrix.length -1;
                    }
                    break;


                case "right":
                    startCol++;
                    if (startCol > matrix.length-1){
                        startCol = 0;
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (field.equals("F")){
                System.out.println("Player won!");
                hasWon = true;
                break;
            }
            else if (field.equals("B")){
                continue;
            }
            else if (field.equals("T")){
                startCol = previousCol;
                startRow = preciousRow;
                field = matrix[startRow][startCol];
            }
            command = scanner.nextLine();
        }

        if (!hasWon) {
            System.out.println("Player lost!");

        }
        matrix[startRow][startCol] = "P";
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }
}