package methodsExercise;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            reversedCommand(command);
            System.out.println(reversedCommand(command));

            command = scanner.nextLine();
        }

    }
    private static String reversedCommand (String command) {
        String output = "";
        String reversed = "";
        for (int i = command.length() - 1; i >= 0; i--) {
            reversed += command.charAt(i);
        }
        if (reversed.equals(command)) {
            output = "true";
        } else {
            output = "false";
        }
        return output;
    }


    }
