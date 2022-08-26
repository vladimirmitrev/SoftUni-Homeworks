package methodsExercise;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();

        printVowelsCount(text);

    }
    private static void printVowelsCount (String text) {
            int count = 0;
        for (char symbol:text.toCharArray()) {
            if (symbol == 'a' || symbol == 'e' || symbol == 'o'
                    || symbol == 'i' || symbol == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }
}
