package textProcessingExercise;

import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder modifiedText = new StringBuilder();

        char startLetter = text.charAt(0);
        modifiedText.append(startLetter);

        for (int i = 1; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (currentSymbol != startLetter) {
                modifiedText.append(currentSymbol);
                startLetter = currentSymbol;
            }
        }
        System.out.println(modifiedText);
    }
}
