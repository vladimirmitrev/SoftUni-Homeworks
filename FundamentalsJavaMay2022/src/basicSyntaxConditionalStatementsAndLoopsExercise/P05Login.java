package basicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";
        int badAttempts = 0;

        for (int position = username.length() - 1; position >= 0; position--) {
            char currentSymbol = username.charAt(position);
            password += currentSymbol;
        }
        String enteredPass = scanner.nextLine();

        while (!enteredPass.equals(password)) {
            badAttempts++;
            if (badAttempts == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");

            enteredPass = scanner.nextLine();
        }
        if (enteredPass.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
