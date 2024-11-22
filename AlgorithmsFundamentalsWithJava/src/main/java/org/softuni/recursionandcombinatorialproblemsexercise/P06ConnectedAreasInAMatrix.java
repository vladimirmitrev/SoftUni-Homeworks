package org.softuni.recursionandcombinatorialproblemsexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class P06ConnectedAreasInAMatrix {

    public static char[][] matrix;
    public static  List<int[]> areas;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int r = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        matrix = new char[r][c];

        for (int i = 0; i < r; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }

        areas = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == '-') {
                    areas.add(new int[] {row, col, 0});
                    finaArea(row, col);
                }
            }
        }

        System.out.println("Total areas found: " + areas.size());

        AtomicInteger counter = new AtomicInteger(1);

        areas.stream()
                .sorted((f, s) -> Integer.compare(s[2],f[2]))
                .forEach(a -> {
                    System.out.println("Area #" + counter.getAndIncrement() + " at (" + a[0] +", "+ a[1] +"), size: " + a[2]);
                });
    }

    private static void finaArea(int row, int col) {
        if (isOutOfBounds(row, col) || isNotTraversal(row, col)) {
            return;
        }

        matrix[row][col] = 'V';

        areas.get(areas.size() - 1)[2]++;

        finaArea(row + 1, col);
        finaArea(row, col + 1);
        finaArea(row - 1, col);
        finaArea(row, col - 1);
    }

    private static boolean isNotTraversal(int row, int col) {
        return matrix[row][col] == 'V' || matrix[row][col] == '*';
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
