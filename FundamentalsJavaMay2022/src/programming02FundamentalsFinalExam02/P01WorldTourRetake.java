package programming02FundamentalsFinalExam02;

import java.util.Scanner;

public class P01WorldTourRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String stops = scanner.nextLine();
            StringBuilder stopsBuilder = new StringBuilder(stops);

            String input = scanner.nextLine();
            while (!input.equals("Travel")){
                String[] tokens = input.split(":");
                String command = tokens[0];

                if(command.equals("Add Stop")) {
                    int index = Integer.parseInt(tokens[1]);
                    String newString = tokens[2];
                    if(isValidIndex(stopsBuilder, index)) {

                        stopsBuilder.insert(index, newString);

                    }
                } else if(command.equals("Remove Stop")) {

                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if(isValidIndex(stopsBuilder, startIndex) && isValidIndex(stopsBuilder, endIndex)) {
                        stopsBuilder.delete(startIndex, endIndex + 1);

                    }

                } else if(command.equals("Switch")) {
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    if(stops.contains(oldString)) {

                        String newText = stopsBuilder.toString().replace(oldString, newString);
                        stopsBuilder = new StringBuilder(newText);
                    }

                }
                System.out.println(stopsBuilder);

                input = scanner.nextLine();
            }
        System.out.printf("Ready for world tour! Planned stops: %s", stopsBuilder);

    }

    private static boolean isValidIndex(StringBuilder stops, int index) {
        return index >= 0 && index <= stops.length() - 1;
    }
}
