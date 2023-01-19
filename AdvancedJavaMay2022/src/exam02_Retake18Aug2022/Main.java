package exam02_Retake18Aug2022;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        var rows = dimensions[0];
        var columns = dimensions[1];

        var field = readField(scanner, rows);
        var directions = readDirections(scanner);
        var playersPositions = findPlayersPosition(field);
        var playerXPosition = playersPositions[0];
        var playerYPosition = playersPositions[1];

        var moves = new ArrayList<String>();

        for (var i = 0; i < directions.length; i++) {
            var direction = directions[i];
            switch (direction) {
                case "up":
                    if (playerXPosition - 1 >= 0 && field[playerXPosition - 1][playerYPosition] != 'T') {
                        playerXPosition--;
                        moves.add(direction);
                    }
                    break;
                case "down":
                    if (playerXPosition + 1 < rows && field[playerXPosition + 1][playerYPosition] != 'T') {
                        playerXPosition++;
                        moves.add(direction);
                    }
                    break;
                case "left":
                    if (playerYPosition - 1 >= 0 && field[playerXPosition][playerYPosition - 1] != 'T') {
                        playerYPosition--;
                        moves.add(direction);
                    }
                    break;
                case "right":
                    if (playerYPosition + 1 < columns && field[playerXPosition][playerYPosition + 1] != 'T') {
                        playerYPosition++;
                        moves.add(direction);
                    }
                    break;
            }
            if (checkPosition(field, playerXPosition, playerYPosition, moves)) {
                return;
            }
        }
        System.out.println("The map is fake!");
    }

    private static boolean checkPosition(char[][] field, int playerXPosition, int playerYPosition, List<String> moves) {
        if (field[playerXPosition][playerYPosition] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", moves));
            return true;
        }
        return false;
    }

    private static int[] findPlayersPosition(char[][] field) {
        for (var i = 0; i < field.length; i++) {
            for (var j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'Y') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }

    private static String[] readDirections(Scanner scanner) {
        var command = scanner.nextLine();
        var list = new ArrayList<String>();
        while (!command.equals("Finish")) {
            list.add(command);
            command = scanner.nextLine();
        }
        return list.toArray(String[]::new);
    }

    private static char[][] readField(Scanner scanner, int rows) {
        var field = new char[rows][];
        for (var i = 0; i < rows; i++) {
            field[i] = scanner.nextLine().replace(" ", "").toCharArray();
        }
        return field;
    }
}