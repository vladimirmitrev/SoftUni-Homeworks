package moreExercisesNestedLoops;

import java.util.Scanner;

public class P02_LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLetter = scanner.nextLine();
        String lastLetter = scanner.nextLine();
        String noLetter = scanner.nextLine();
        int combinations = 0;

        for (char letter1 = firstLetter.charAt(0); letter1 <= lastLetter.charAt(0); letter1++) {
            for (char letter2 = firstLetter.charAt(0); letter2 <= lastLetter.charAt(0); letter2++) {
                for (char letter3 = firstLetter.charAt(0);letter3 <= lastLetter.charAt(0); letter3++) {
                    String output = "" + letter1 + letter2 + letter3;
                    if (!output.contains(noLetter)) {
                        System.out.printf("%s ", output);
                        combinations++;
                    }
                }
            }
        }
        System.out.print(combinations);
    }
}
