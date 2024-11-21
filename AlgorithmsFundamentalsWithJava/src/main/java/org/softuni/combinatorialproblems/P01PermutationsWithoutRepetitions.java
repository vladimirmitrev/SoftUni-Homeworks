package org.softuni.combinatorialproblems;

import java.util.Scanner;

public class P01PermutationsWithoutRepetitions {

    public static String[] elements;
//    public static String[] permutesArr;
//    public static boolean[] used;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        permute(0);
//        permutesArr = new String[elements.length];
//        used = new boolean[elements.length];

    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(elements);
            return;
        }
        permute(index + 1);
        for (int i = index + 1; i < elements.length; i++) {
            swap(elements, index, i);
            permute(index + 1);
            swap(elements, index, i);
//            if (!used[i]) {
//                used[i] = true;
//                permutesArr[index] = elements[i];
//                permute(index + 1);
//                used[i] = false;
//            }
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
