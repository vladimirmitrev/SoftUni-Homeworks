package programming03FundamentalsFinalExamRetake;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P01SecretChatRetake2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    String firstPart = message.substring(0, index);
                    String space = " ";
                    String secondPart = message.substring(index);
                    message = firstPart.concat(space).concat(secondPart);

                    System.out.println(message);
                    break;

                case "Reverse":
                    String givenSubstring = tokens[1];
                    if (message.contains(givenSubstring)) {
                        message = message.replaceFirst(Pattern.quote(givenSubstring), "");
                        String reverseWord = new StringBuilder(givenSubstring).reverse().toString();
                        message = message.concat(reverseWord);
                        System.out.println(message);

                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String oldText = tokens[1];
                    String newText = tokens[2];
                    message = message.replace(oldText, newText);
                    System.out.println(message);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", message);

    }
}
