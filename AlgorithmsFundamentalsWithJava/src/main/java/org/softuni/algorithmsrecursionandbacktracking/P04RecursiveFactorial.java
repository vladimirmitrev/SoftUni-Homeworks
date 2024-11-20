package org.softuni.algorithmsrecursionandbacktracking;

import java.util.Scanner;

public class P04RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

//        long fact = 1;
//
//        for (int i = 1; i <= n; i++) {
//            fact *= i;
//        }
//
//        System.out.println(fact);

        long result = calculateFactorial(n);

        System.out.println(result);
    }

    private static long calculateFactorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * calculateFactorial(n - 1);
    }
}
