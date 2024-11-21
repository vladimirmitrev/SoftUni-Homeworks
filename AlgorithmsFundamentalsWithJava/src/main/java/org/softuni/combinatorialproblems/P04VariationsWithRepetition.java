package org.softuni.combinatorialproblems;

import java.util.Scanner;

public class P04VariationsWithRepetition {
    public static String[] elements;
    public static String[] variationsArr;
    public static boolean[] used;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        int k = Integer.parseInt(scanner.nextLine());

        variationsArr = new String[k];

        used = new boolean[elements.length];

        variations(0);
    }

    private static void variations(int index) {
        if (index == variationsArr.length) {
            print(variationsArr);
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            variationsArr[index] = elements[i];
            variations(index + 1);
        }
    }

    private static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
