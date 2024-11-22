package org.softuni.recursionandcombinatorialproblemsexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02NestedLoopsToRecursion {

    public static StringBuilder output = new StringBuilder();
    public static int[] arr;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n];

        permute(0);
        System.out.print(output);
    }

    private static void permute(int index) {
        if (index == n) {
            for (int i = 0; i < n; i++) {
                output.append(arr[i]).append(" ");
            }
            output.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[index] = i;
            permute(index + 1);
        }
    }
}
