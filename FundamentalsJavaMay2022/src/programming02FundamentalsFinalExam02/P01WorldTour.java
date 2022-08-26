package programming02FundamentalsFinalExam02;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String allStops = scanner.nextLine();

        String input = scanner.nextLine();
        StringBuilder stopsBuilder = new StringBuilder(allStops);

        while (!input.equals("Travel")) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String stringToInsert = tokens[2];
                    if (isValidIndex(index,stopsBuilder)) {
                        stopsBuilder.insert(index, stringToInsert);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if(isValidIndex(startIndex, stopsBuilder) && isValidIndex(endIndex, stopsBuilder)) {
                       stopsBuilder.delete(startIndex, endIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if(allStops.contains(oldString)) {
                        String newText = stopsBuilder.toString().replace(oldString, newString);
                        stopsBuilder = new StringBuilder(newText);
                    }

                    break;
            }
            System.out.println(stopsBuilder);
            input = scanner.nextLine();

        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", stopsBuilder);

    }
    public static boolean isValidIndex (int index, StringBuilder builder) {

        return index <= builder.length() - 1 && index >= 0;
    }

}

