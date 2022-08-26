package moreExercisesNestedLoops;

import java.util.Scanner;

public class P09_SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());

        int countNum = 0;
        boolean isValid = false;

        for (int i = startNum; i <= endNum ; i++) {
            for (int j = startNum; j <= endNum ; j++) {
                countNum++;
                int sum = i + j;

                if (sum == magicNum) {
                    isValid = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", countNum, i, j, sum);
                    break;
                }
            }
           if (isValid) {
               break;
           }
        }
        if (!isValid) {
            System.out.printf("%d combinations - neither equals %d", countNum, magicNum);
        }
    }
}
