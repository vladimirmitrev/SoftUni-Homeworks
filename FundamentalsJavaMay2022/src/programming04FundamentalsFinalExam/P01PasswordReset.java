package programming04FundamentalsFinalExam;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Done")) {
                String[] command = commandLine.split(" ");

                if(commandLine.contains("TakeOdd")) {
                    String decrypted = "";
                    for (int i = 1; i < text.length() ; i += 2) {
                        decrypted += text.charAt(i);
                    }
                    text = decrypted;
                    System.out.println(text);

                } else if(commandLine.contains("Cut")) {
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    StringBuilder textBuilder = new StringBuilder(text);
                    textBuilder.delete(index, index + length);
                    text = textBuilder.toString();
                    System.out.println(text);

                } else if(commandLine.contains("Substitute")) {
                    String substring = command[1];
                    String substitute = command[2];
                    if(text.contains(substring)) {
                        text = text.replace(substring, substitute);
                        System.out.println(text);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                }
            commandLine = scanner.nextLine();
        }
        System.out.printf("Your password is: %s%n", text);
    }
}
