package programming04FundamentalsFinalExam;

import java.util.Scanner;

public class P01PasswordResetRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "TakeOdd":
                    StringBuilder messageBuilder = new StringBuilder();
                    for (int i = 1; i < message.length() ; i += 2) {
                        char symbol = message.charAt(i);
                        messageBuilder.append(symbol);
                    }
                    message = messageBuilder.toString();
                    System.out.println(message);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    StringBuilder textBuilder = new StringBuilder(message);
                    textBuilder.delete(index, index + length);
                    message = textBuilder.toString();
                    System.out.println(message);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    if(message.contains(substring)) {
                        message = message.replace(substring, replacement);
                        System.out.println(message);
                    } else {
                        System.out.println("Nothing to replace!");
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", message);
    }
}
