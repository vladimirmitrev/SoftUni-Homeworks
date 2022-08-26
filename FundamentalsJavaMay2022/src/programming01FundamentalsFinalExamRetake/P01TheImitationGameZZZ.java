package programming01FundamentalsFinalExamRetake;

import java.util.Scanner;

public class P01TheImitationGameZZZ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    String moveLetters = message.substring(0, numberOfLetters);
                    message = message.replace(moveLetters, "");
                    message = message.concat(moveLetters);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String givenValue = tokens[2];
                    String substring1 = message.substring(0, index);
                    String afterSubstring = message.substring(index);
                    message = substring1.concat(givenValue).concat(afterSubstring);

                    break;
                case "ChangeAll":
                    String changeAll = tokens[1];
                    String newChars = tokens[2];
                    message = message.replace(changeAll, newChars);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", message);
    }
}
