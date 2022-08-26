package exam6and7July2019;

import java.util.Scanner;

public class P06_TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String word = "";
        int maxSum = Integer.MIN_VALUE;

        while (!input.equals("End of words")) {
            int currentSum = 0;

            boolean check = false;

            for (int i = 0; i < input.length() ; i++) {
                int ascii = 0;
                char current = input.charAt(i);
                ascii = (int) current;
                currentSum += ascii;
                boolean isVowel = current == 'a' || current == 'o' || current == 'e' || current == 'i' || current == 'u' || current == 'y' ||
                        current == 'A' || current == 'O' || current == 'E' || current == 'I' || current == 'U' || current == 'Y';
                if (i == 0 && isVowel) {
                    check = true;
                }
            }
            if (check) {
                currentSum = currentSum * input.length();
            } else {
                currentSum = currentSum / 3;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                word = input;
            }
            input = scanner.nextLine();
        }
        System.out.printf("The most powerful word is %s - %d", word, maxSum);
    }
}
