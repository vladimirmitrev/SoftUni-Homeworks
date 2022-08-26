package methodsExercise;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean isPasswordLengthValid = isValidLength(password);

        if (!isPasswordLengthValid) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        boolean isPasswordContentValid = isValidContent(password);

        if (!isPasswordContentValid) {
            System.out.println("Password must consist only of letters and digits");
        }
        boolean isPasswordCountDigitsValid = isValidCountDigits(password);

        if (!isPasswordCountDigitsValid) {
            System.out.println("Password must have at least 2 digits");
        }
        if (isPasswordCountDigitsValid && isPasswordLengthValid && isPasswordContentValid) {
            System.out.println("Password is valid");
        }


    }

    private static boolean isValidLength (String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean isValidContent (String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCountDigits (String password) {
        int countDigits = 0;
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                countDigits++;
            }
        }
        return countDigits >= 2;

    }
}
