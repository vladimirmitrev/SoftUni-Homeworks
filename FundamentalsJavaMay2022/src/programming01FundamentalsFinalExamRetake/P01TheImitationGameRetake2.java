package programming01FundamentalsFinalExamRetake;

import java.util.Scanner;

public class P01TheImitationGameRetake2 {
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
                    String firstPart = message.substring(0, numberOfLetters);
                    String secondPart =  message.substring(numberOfLetters);
                    message = secondPart.concat(firstPart);

                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    String firstPart2 = message.substring(0, index);
                    String secondPart2 = message.substring(index);
                    message = firstPart2.concat(value).concat(secondPart2);

                    break;

                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];

                    message = message.replace(substring, replacement);

                    break;

            }

            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n", message);
    }
}
