package programming01FundamentalsFinalExamRetake;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String command = scanner.nextLine();


        while (!command.equals("Decode")) {
            String[] commandPart = command.split("\\|");

            if(command.contains("Move")) {
                int numberOfLetters = Integer.parseInt(commandPart[1]);
                String firstPart = text.substring(0, numberOfLetters);
                String secondPart = text.substring(numberOfLetters);
                text = secondPart.concat(firstPart);

            } else if(command.contains("Insert")) {
                int index = Integer.parseInt(commandPart[1]);
                String givenText = commandPart[2];
                String firstPart = text.substring(0, index);
                String secondPart = text.substring(index);

                text = firstPart.concat(givenText).concat(secondPart);

            } else if(command.contains("ChangeAll")) {
                String oldChar = commandPart[1];
                String newChar = commandPart[2];
                text = text.replace(oldChar, newChar);
            }

            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", text);
    }
}
