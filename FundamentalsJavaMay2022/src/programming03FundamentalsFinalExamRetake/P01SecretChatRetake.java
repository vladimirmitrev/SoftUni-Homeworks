package programming03FundamentalsFinalExamRetake;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P01SecretChatRetake {
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
                        String space = " ";
                        String sub1 = message.substring(0, index);
                        String sub2 = message.substring(index);
                        message = sub1.concat(space).concat(sub2);
                        System.out.println(message);

                        break;
                    case "Reverse":
                        String givenSubstring = tokens[1];
                        if(message.contains(givenSubstring)) {
                            message = message.replaceFirst(Pattern.quote(givenSubstring), "")
                                    .concat(new StringBuilder(givenSubstring).reverse().toString());
//          87 точки          StringBuilder substringBuilder = new StringBuilder(givenSubstring).reverse();
//                            String reversedText = substringBuilder.toString();
//                            message = message.replace(givenSubstring, reversedText);

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
        System.out.println("You have a new text message: " + message);
    }
}
