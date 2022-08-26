package programming05FundamentalsFinalExam;

import java.util.Scanner;

public class P01ActivationKeysRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    String substringGiven = tokens[1];
                    if(activationKey.contains(substringGiven)) {
                        System.out.printf("%s contains %s%n", activationKey, substringGiven);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String substring = activationKey.substring(startIndex, endIndex);
                    if(upperOrLower.equals("Upper")) {
                        activationKey = activationKey.replace(substring, substring.toUpperCase());
                    } else if(upperOrLower.equals("Lower")) {
                        activationKey = activationKey.replace(substring, substring.toLowerCase());
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int startIndexSlice = Integer.parseInt(tokens[1]);
                    int endIndexSlice = Integer.parseInt(tokens[2]);
                    String substringSlice = activationKey.substring(startIndexSlice, endIndexSlice);
                    activationKey = activationKey.replace(substringSlice, "");

                    System.out.println(activationKey);
                    break;

            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", activationKey);
    }
}
