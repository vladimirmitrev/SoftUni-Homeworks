package dataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int lines = Integer.parseInt(scanner.nextLine());
        String message = "";

        while (lines > 0 ) {
            char currentChar = scanner.nextLine().charAt(0);
            message = message + (currentChar + key);
            lines--;
        }
        System.out.println(message);
    }
}
