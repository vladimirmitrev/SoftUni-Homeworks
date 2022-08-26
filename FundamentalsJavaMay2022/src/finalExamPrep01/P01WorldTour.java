package finalExamPrep01;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();

        String command = scanner.nextLine();

        StringBuilder stopsBuilder = new StringBuilder(stops);

        while (!command.equals("Travel")) {

            if(command.contains("Add Stop")) {
                int index = Integer.parseInt(command.split(":")[1]);
                String newStop = command.split(":")[2];
                if(isValidIndex(index, stopsBuilder)) {
                    stopsBuilder.insert(index, newStop);
                }
            } else if(command.contains("Remove Stop")) {
                int starIndex = Integer.parseInt(command.split(":")[1]);
                int endIndex = Integer.parseInt(command.split(":")[2]);
                if(isValidIndex(starIndex, stopsBuilder) && isValidIndex(endIndex, stopsBuilder)) {
                    stopsBuilder.delete(starIndex, endIndex + 1);
                }
            } else if (command.contains("Switch")) {
                String oldStop = command.split(":")[1];
                String newStop = command.split(":")[2];
                if(stops.contains(oldStop)) {
                    String newText = stopsBuilder.toString().replace(oldStop, newStop);
                    stopsBuilder = new StringBuilder(newText);
                }
            }
            System.out.println(stopsBuilder);
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stopsBuilder);
    }
    public static boolean isValidIndex(int index, StringBuilder builder) {

        return index >= 0 && builder.length() - 1 >= index;
    }
}
