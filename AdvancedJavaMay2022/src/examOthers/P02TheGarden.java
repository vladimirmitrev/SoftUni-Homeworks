package examOthers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02TheGarden {
    private static char[][] matrix;
    private static Map<String, Integer> vegetables;
    private static int countHarmed = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        readMatrix(scanner, Integer.parseInt(scanner.nextLine()));
        vegetables = new LinkedHashMap<>() {{ put("Carrots", 0); put("Potatoes",0); put("Lettuce", 0);}};
        String input;
        int row, col;

        while (!"End of Harvest".equals(input = scanner.nextLine())) {
            String[] command = input.split("\\s+");
            row = Integer.parseInt(command[1]);
            col = Integer.parseInt(command[2]);

            if (command[0].equals("Harvest")) {
                checkVegetable(row, col);
            } else {
                if (isValidIndexes(row, col)) {
                    if ("up".equals(command[3])) {
                        moveToNext(row, col, -2, "rows");
                    } else if ("down".equals(command[3])) {
                        moveToNext(row, col, 2, "rows");
                    } else if ("left".equals(command[3])) {
                        moveToNext(row, col, -2, "cols");
                    } else if ("right".equals(command[3])) {
                        moveToNext(row, col, 2, "cols");
                    }
                }
            }
        }
        printMatrix();
        vegetables.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        System.out.println("Harmed vegetables: " + countHarmed);

    }

    private static void moveToNext(int row, int col, int index, String direction) {
        while (isValidIndexes(row, col)) {
            checkCell(row, col);
            if (direction.equals("rows")) {
                row = Math.abs(row) + index;
            } else {
                col = Math.abs(col) + index;
            }
        }
    }

    private static void checkCell(int row, int col) {
        if (matrix[row][col] != ' ') {
            countHarmed++;
            matrix[row][col] = ' ';
        }
    }

    private static void checkVegetable(int row, int col) {
        if (isValidIndexes(row, col)) {
            char current = matrix[row][col];
            if (current == 'L') {
                vegetables.put("Lettuce", vegetables.get("Lettuce") + 1);
            } else if (current == 'P') {
                vegetables.put("Potatoes", vegetables.get("Potatoes") + 1);
            } else if (current == 'C') {
                vegetables.put("Carrots", vegetables.get("Carrots") + 1);
            }
            matrix[row][col] = ' ';
        }
    }

    private static boolean isValidIndexes(int row, int col) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length);
    }

    private static void readMatrix(Scanner scan, int n) {
        matrix = new char[n][];
        for (int row = 0; row < n; row++) {
            matrix[row] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }

    private static void printMatrix() {
        Arrays.stream(matrix).forEach(e -> System.out.println(Arrays.toString(e)
                .replaceAll("[\\[\\]]", "").replaceAll(", ", " ")));
    }
}
