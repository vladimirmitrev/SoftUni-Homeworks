package programming03FundamentalsFinalExamRetake;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Reveal")) {
            String[] commandData = command.split(":\\|:");

            if(command.contains("InsertSpace")) {
                int index = Integer.parseInt(commandData[1]);
                String space = " ";
                StringBuilder textBuilder = new StringBuilder(text);
                textBuilder.insert(index, space);
                text = textBuilder.toString();
                System.out.println(text);

            } else if(command.contains("Reverse")) {
                String givenString = commandData[1];
                if(text.contains(givenString)) {
                    text = text.replaceFirst(Pattern.quote(givenString), "")
                            .concat(new StringBuilder(givenString).reverse().toString());
//                    StringBuilder builder = new StringBuilder(givenString).reverse();
//                    String reversedText = builder.toString();
//                    text = text.replace(givenString, reversedText);
                    System.out.println(text);

                } else {
                    System.out.println("error");
                }

            } else if(command.contains("ChangeAll")){
                String replaceOld = commandData[1];
                String replaceNew = commandData[2];
                text = text.replace(replaceOld, replaceNew);
                System.out.println(text);
            }

            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", text);
    }
}
