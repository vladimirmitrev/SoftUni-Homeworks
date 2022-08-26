package textProcessingExercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] texts = input.split("\\s+");
        double totalSum = 0;

        for (String text : texts) {

            double number = modifiedNumber(text);
            totalSum += number;
        }
        System.out.printf("%.2f", totalSum);

    }

    private static double modifiedNumber(String text) {

        char firstLetter = text.charAt(0);
        char secondLetter = text.charAt(text.length() - 1);

        double number = Double.parseDouble(text.replace(firstLetter, ' ')
                                                .replace(secondLetter, ' ')
                                                .trim());

        if(Character.isUpperCase(firstLetter)) {
            int letterPosition = (int) firstLetter - 64;
            number /= letterPosition;

        } else {
            int letterPosition = (int) firstLetter - 96;
            number *= letterPosition;
        }

        if (Character.isUpperCase(secondLetter)) {
            int letterPosition = (int) secondLetter - 64;
            number -= letterPosition;
        } else {
            int letterPosition = (int) secondLetter - 96;
            number += letterPosition;
        }
        return number;
    }
}
