package org.softuni.algorithmsrecursionandbacktracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P07RecursiveFibonacci {
    public static Map<Integer, Long> memoizeTable = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fibonacci(n));
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memoizeTable.containsKey(n)) {
            return memoizeTable.get(n);
        }

        long result = fibonacci(n - 1) + fibonacci(n - 2);
        memoizeTable.put(n, result);

        return result;
    }
}
