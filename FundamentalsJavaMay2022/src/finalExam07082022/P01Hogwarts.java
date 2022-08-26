package finalExam07082022;

import java.util.Scanner;

public class P01Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input = scanner.nextLine();



        while (!input.equals("Abracadabra")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Abjuration":
                    text = text.toUpperCase();
                    System.out.println(text);

                    break;
                case "Necromancy":
                    text = text.toLowerCase();
                    System.out.println(text);

                    break;
                case "Illusion":
                    int index = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];

                    if (index >= 0 && index <= text.length() - 1) {
                        StringBuilder textBuilder = new StringBuilder(text);
                        textBuilder.deleteCharAt(index);
                        text = textBuilder.toString();
                        String firstPart = text.substring(0, index);
                        String secondPart = text.substring(index);
                        text = firstPart.concat(letter).concat(secondPart);
                        System.out.println("Done!");

                    } else {
                        System.out.println("The spell was too weak.");
                    }

                    break;
                case "Divination":
                    String oldText = tokens[1];
                    String newText = tokens[2];
                    text = text.replace(oldText, newText);
                    System.out.println(text);

                    break;
                case "Alteration":
                    String textToRemove = tokens[1];
                    text = text.replace(textToRemove, "");
                    System.out.println(text);
                    break;

                default:
                    System.out.println("The spell did not work!");
                    break;

            }

            input = scanner.nextLine();
        }

    }
}
