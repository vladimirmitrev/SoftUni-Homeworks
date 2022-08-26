package programmingFundamentalsMidExam26June2022;

import java.util.Arrays;
import java.util.Scanner;

public class P03TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] priceArray = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetIndex = Integer.parseInt(scanner.nextLine());
        String priceType = scanner.nextLine();

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < targetIndex ; i++) {
            if (priceType.equals("cheap")) {
                   if(priceArray[i] < priceArray[targetIndex]) {
                    if (priceArray[i] >= 0) {
                        leftSum += priceArray[i];
                    } else {
                        leftSum = leftSum - (-priceArray[i]);
                    }
                }
            } else if (priceType.equals("expensive")) {
                if (priceArray[i] >= priceArray[targetIndex]) {
                    if (priceArray[i] >= 0) {
                        leftSum += priceArray[i];
                    } else {
                        leftSum = leftSum - (-priceArray[i]);
                    }

                }
            }

        }
        for (int i = targetIndex + 1; i <= priceArray.length - 1; i++) {
            if (priceType.equals("cheap")) {
                if(priceArray[i] < priceArray[targetIndex]) {
                    if (priceArray[i] >= 0) {
                        rightSum += priceArray[i];
                    } else {
                        rightSum = rightSum - (-priceArray[i]);
                    }
                }
            } else if (priceType.equals("expensive")) {
                if (priceArray[i] >= priceArray[targetIndex]) {
                    if (priceArray[i] >= 0) {
                        rightSum += priceArray[i];
                    } else {
                        rightSum = rightSum - (-priceArray[i]);
                    }

                }
            }

        }

        if (leftSum >= rightSum) {
            System.out.printf("Left - %d", leftSum);
        } else {
            System.out.printf("Right - %d", rightSum);
        }
    }
}
