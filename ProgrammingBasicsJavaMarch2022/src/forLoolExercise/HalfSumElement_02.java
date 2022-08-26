package forLoolExercise;

import java.util.Scanner;

public class HalfSumElement_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        int maxNum = Integer.MIN_VALUE;

        for (int i = 1; i <= n ; i++) {

            int currentNum = Integer.parseInt(scanner.nextLine());

            sum = sum + currentNum;

            if (currentNum > maxNum) {
                maxNum = currentNum;

            }
        }
        sum = sum - maxNum;

        if (maxNum == sum) {
            System.out.printf("Yes%nSum = " + maxNum);
        } else {
            System.out.printf("No%nDiff = %s", Math.abs(sum - maxNum));
        }
    }
}
