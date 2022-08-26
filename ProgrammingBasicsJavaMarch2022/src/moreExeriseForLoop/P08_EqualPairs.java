package moreExeriseForLoop;

import java.util.Scanner;

public class P08_EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int firstSum = 0;
        int midSum = 0;
        int diff = 0;

        boolean check = true;

        for (int i = 1; i <= n ; i++) {
            int input1 = Integer.parseInt(scanner.nextLine());
            int input2 = Integer.parseInt(scanner.nextLine());
            if (i % 2 != 0) {
                firstSum = input1 + input2;
            } else {
                midSum = input1 + input2;
            }
            if (firstSum == midSum || n < 2) {
                check = true;
            } else {
                diff = Math.abs(midSum - firstSum);
                check = false;
            }
        }
        if (check) {
            System.out.printf("Yes, value=%d",firstSum);
        } else {
            System.out.printf("No, maxdiff=%d", diff);
        }
    }
}
