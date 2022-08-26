package programming04FundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P01PasswordResetRetake2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedPassword = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "TakeOdd":
                    String newPassword = "";
                    for (int i = 1; i < encryptedPassword.length() ; i = i + 2) {

                        char symbol = encryptedPassword.charAt(i);
                        newPassword += symbol;
                    }
                    encryptedPassword = newPassword;
                    System.out.println(encryptedPassword);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String substring = encryptedPassword.substring(index, index + length);
                    encryptedPassword = encryptedPassword.replaceFirst(Pattern.quote(substring), "");
                    System.out.println(encryptedPassword);

                    break;
                case "Substitute":
                    String oldText = tokens[1];
                    String newText = tokens[2];
                    if(encryptedPassword.contains(oldText)) {
                        encryptedPassword = encryptedPassword.replace(oldText, newText);
                        System.out.println(encryptedPassword);
                    } else {
                        System.out.println("Nothing to replace!");
                    }

                    break;

            }

            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", encryptedPassword);

    }
}
