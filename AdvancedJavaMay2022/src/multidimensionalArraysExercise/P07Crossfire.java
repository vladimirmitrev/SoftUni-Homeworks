package multidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];


        List<List<Integer>> matrix = new ArrayList<>();

        int counter = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter++);
            }
        }
        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Nuke it from orbit")) {
            String[] input = commandLine.split(" ");
            int rowToDestroy = Integer.parseInt(input[0]);
            int colToDestroy = Integer.parseInt(input[1]);
            int radius = Integer.parseInt(input[2]);

            for (int row = rowToDestroy - radius; row <= rowToDestroy + radius; row++) {
                if (isInRange(row, colToDestroy, matrix) && row != rowToDestroy) {
                    matrix.get(row).remove(colToDestroy);
                }
            }
            for (int col = colToDestroy + radius; col >= colToDestroy - radius; col--) {
                if (isInRange(rowToDestroy, col, matrix)) {
                    matrix.get(rowToDestroy).remove(col);

                }
            }
            matrix.removeIf(List::isEmpty);

            commandLine = scanner.nextLine();
        }
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    private static boolean isInRange(int row, int colToDestroy, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && colToDestroy >= 0 && colToDestroy < matrix.get(row).size();
    }
}
