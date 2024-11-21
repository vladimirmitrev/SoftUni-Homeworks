package org.softuni.combinatorialproblems;

import java.util.Scanner;

public class P05CombinationsWithoutRepetition {
    public static String[] elements;
    public static String[] variationsArr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        int k = Integer.parseInt(scanner.nextLine());

        variationsArr = new String[k];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index == variationsArr.length) {
            print(variationsArr);
        } else {
            for (int i = start; i < elements.length; i++) {
                variationsArr[index] = elements[i];
                combinations(index + 1, i + 1);
            }
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
