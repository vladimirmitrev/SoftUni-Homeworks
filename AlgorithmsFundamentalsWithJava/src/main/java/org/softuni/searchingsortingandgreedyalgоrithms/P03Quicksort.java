package org.softuni.searchingsortingandgreedyalgоrithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P03Quicksort {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(arr);

        StringBuilder builder = new StringBuilder();

        for (int number : arr) {
            builder.append(number).append(" ");
        }

        System.out.println(builder.toString());

    }

    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partition(arr, left, right);
        quickSort(arr, left, index -1 );
        quickSort(arr, index + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
