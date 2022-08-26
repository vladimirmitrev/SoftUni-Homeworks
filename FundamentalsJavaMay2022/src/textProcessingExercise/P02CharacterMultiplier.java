package textProcessingExercise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String firstStr = input[0];
        String secondStr = input[1];

        long sum = sumOfCharacters(firstStr, secondStr);

        System.out.println(sum);

    }

    private static long sumOfCharacters(String firstStr, String secondStr) {

        char[] firstArr = firstStr.toCharArray();
        char[] secondArr = secondStr.toCharArray();

        int minLength = Math.min(firstArr.length, secondArr.length);
        int maxLength = Math.max(firstArr.length, secondArr.length);

        long sum = 0;

        for (int i = 0; i < minLength ; i++) {

            sum += firstArr[i] * secondArr[i];
        }
        if (maxLength == firstArr.length) {

            for (int i = minLength; i < maxLength ; i++) {
                sum += firstArr[i];
            }
        } else {
            for (int i = minLength; i < maxLength ; i++) {
                sum += secondArr[i];
            }
        }
        return sum;

    }
}
