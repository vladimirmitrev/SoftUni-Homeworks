package programming01FundamentalsFinalExamRetake;

import java.util.Scanner;

public class P01TheImitationGameRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    String substring1 = text.substring(0, numberOfLetters);
                    String substring2 = text.substring(numberOfLetters);
                    text = substring2.concat(substring1);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String givenValue = tokens[2];
                    StringBuilder textBuilder = new StringBuilder(text);
                    textBuilder = textBuilder.insert(index, givenValue);
                    text = textBuilder.toString();
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    text = text.replace(substring, replacement);

                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", text);
    }
}
