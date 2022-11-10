package exam07_26June2021;

import java.util.Scanner;

public class P02Python2 {
    private static int snakeRow;
    private static int snakeCol;
    private static int foodToEat;
    private static int totalLength = 1;
    private static boolean isKilled = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            char[] inputRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[row] = inputRow;
            for (int col = 0; col < size; col++) {
                char currentChar = matrix[row][col];
                if (currentChar == 's') {
                    snakeRow = row;
                    snakeCol = col;
                } else if (currentChar == 'f') {
                    foodToEat++;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            matrix[snakeRow][snakeCol] = '*';
            if(command.equals("up")) {
                snakeRow--;
                if(snakeRow < 0) {
                    snakeRow = size - 1;
                }
            } else if(command.equals("down")) {
                snakeRow++;
                if(snakeRow > size - 1) {
                    snakeRow = 0;
                }
            } else if(command.equals("left")) {
                snakeCol--;
                if(snakeCol < 0) {
                    snakeCol = size - 1;
                }
            } else if (command.equals("right")) {
                snakeCol++;
                if(snakeCol > size - 1) {
                    snakeCol = 0;
                }
            }
            if(matrix[snakeRow][snakeCol] == 'f') {
                totalLength++;
                foodToEat--;
                if(foodToEat == 0) {
                    break;
                }
            } else if (matrix[snakeRow][snakeCol] == 'e') {
                isKilled = true;
                System.out.println("You lose! Killed by an enemy!");
                break;
            }
            matrix[snakeRow][snakeCol] = 's';
        }
        if(!isKilled) {
            if(foodToEat > 0) {
                System.out.printf("You lose! There is still %d food to be eaten.", foodToEat);
            } else {
                System.out.printf("You win! Final python length is %d", totalLength);
            }
        }
    }
}
