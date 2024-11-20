package org.softuni.algorithmsrecursionandbacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class P01RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

//        int sum = 0;
//
//        for (int i = arr.length - 1; i >= 0; i--) {
//            sum += arr[i];
//        }
//
//        System.out.println("Iteration sum: " + sum);

        int sumTwo = sumNumbers(arr, arr.length - 1);

        System.out.println(sumTwo);
    }

    private static int sumNumbers(int[] numbers, int index) {
        if (index < 0) {
            return 0;
        }
        return numbers[index] +  sumNumbers(numbers, index - 1);
    }
}
