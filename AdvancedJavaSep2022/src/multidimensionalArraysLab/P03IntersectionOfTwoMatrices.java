package multidimensionalArraysLab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] first = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            first[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        char[][] second = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            second[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();

        }
        char[][] output = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstElement = first[row][col];
                char secondElement = second[row][col];
                char fillChar = firstElement == secondElement ? firstElement : '*';
                output[row][col] = fillChar;
            }
        }
        for (char[] chars : output) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }
}
