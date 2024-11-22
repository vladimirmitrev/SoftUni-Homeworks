package org.softuni.recursionandcombinatorialproblemsexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03CombinationsWithRepetition {

    public static int n;
    public static int[] arr;
    public static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        arr = new int[k];

        combinations(0, 1);

        System.out.print(output);
    }

    private static void combinations(int index, int start) {
        if (index == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                output.append(arr[i]).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[index] = i;
            combinations(index + 1, i);
        }
    }
}
