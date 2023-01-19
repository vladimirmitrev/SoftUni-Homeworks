package examOthers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P02BookWorm {
    private static char[][] field;
    private static int playerRol;
    private static int playerCol;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        readField(scanner, Integer.parseInt(scanner.nextLine()));
        String command;

        while (!"end".equals(command = scanner.nextLine())) {
            setPosition('-');
            if ("up".equals(command)) {
                moveToRow(-1, input);
            } else if ("down".equals(command)) {
                moveToRow(1, input);
            } else if ("right".equals(command)) {
                moveToCol(1, input);
            } else if ("left".equals(command)) {
                moveToCol(-1, input);
            }
            setPosition('P');
        }
        System.out.println(input.toString());
        printField();
    }

    private static void moveToRow(int n, StringBuilder input) {
        if (isInBounds(playerRol + n)) {
            playerRol += n;
            chekPosition(input);
        } else {
            cutString(input);
        }
    }
    private static void moveToCol(int n, StringBuilder input) {
        if (isInBounds(playerCol + n)) {
            playerCol += n;
            chekPosition(input);
        } else {
            cutString(input);
        }
    }
    private static void setPosition(char c) {
        field[playerRol][playerCol] = c;
    }
    private static void cutString(StringBuilder input) {
        if (input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
        }
    }
    private static void chekPosition(StringBuilder input) {
        if (field[playerRol][playerCol] != '-') {
            input.append(field[playerRol][playerCol]);
        }
    }
    private static boolean isInBounds(int index) {
        return index < field.length && index >= 0;
    }
    private static void printField() {
        Arrays.stream(field).map(row -> Arrays.toString(row)
                .replaceAll("[\\[\\], ]","")).forEach(System.out::println);
    }
    private static void readField(Scanner scan, int n) {
        field = new char[n][n];
        IntStream.range(0, n).forEach(i -> {  String input = scan.nextLine();
            if (input.contains("P")) {
                playerRol = i;
                playerCol = input.indexOf('P');
            }
            field[i] = input.toCharArray();
        });
    }
}
