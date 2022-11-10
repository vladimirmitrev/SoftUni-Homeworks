package exam02_Retake18Aug2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {
    private static int row = 0;
    private static int col = 0;
    private static boolean foundTreasure = false;
    private static List<String> rightMovingList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = (scanner.nextLine().split(" "));

        int rowsSize = Integer.parseInt(input[0]);
        int colsSize = Integer.parseInt(input[1]);

        char[][] matrix = new char[rowsSize][colsSize];

        for (int i = 0; i < rowsSize; i++) {
            char[] arr = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = arr;
            for (int j = 0; j < arr.length; j++) {
                char currentChar = arr[j];
                if (currentChar == 'Y') {
                    row = i;
                    col = j;
                }
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    if (isInBounds(matrix, row - 1, col)) {
                        rightMovingList.add("up");
                        moveHunter(matrix, -1, 0);
                    }
                    break;
                case "down":
                    if (isInBounds(matrix, row + 1, col)) {
                        rightMovingList.add("down");
                        moveHunter(matrix, +1, 0);
                    }
                    break;
                case "left":
                    if (isInBounds(matrix, row, col - 1)) {
                        rightMovingList.add("left");
                        moveHunter(matrix, 0, -1);
                    }
                    break;
                case "right":
                    if (isInBounds(matrix, row, col + 1)) {
                        rightMovingList.add("right");
                        moveHunter(matrix, 0, +1);
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        if (foundTreasure) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is " + String.join(", ", rightMovingList));

        } else {
            System.out.println("The map is fake!");
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void moveHunter(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;


        char nextChar = matrix[nextRow][nextCol];
        if (nextChar == 'X') {
            foundTreasure = true;
        } else if (nextChar == 'T') {
            foundTreasure = false;
            rightMovingList.remove(rightMovingList.size() - 1);
            return;
        } else if(nextChar == '-') {
            foundTreasure = false;
        }

        matrix[row][col] = '-';
        matrix[nextRow][nextCol] = 'Y';
        row = nextRow;
        col = nextCol;
    }
}
