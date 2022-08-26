package conditionStatements;

import java.util.Scanner;

public class PasswordGuess_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPass = scanner.nextLine();

        if (inputPass.equals("s3cr3t!P@ssw0rd")) {
            System.out.println("Welcome");
        } else {
            System.out.println("Wrong password!");
        }
    }
}
