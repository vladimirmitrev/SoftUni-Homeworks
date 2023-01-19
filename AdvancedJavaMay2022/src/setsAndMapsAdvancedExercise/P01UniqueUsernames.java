package setsAndMapsAdvancedExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countWords = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> words = new LinkedHashSet<>();

        for (int i = 0; i < countWords; i++) {
            String input = scanner.nextLine();
            words.add(input);
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
