package functionalProgrammingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        List<String> peopleList = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .collect(Collectors.toList());

        String line = scanner.nextLine();


        List<String> commandLines = new ArrayList<>();

        while (!line.equals("Print")) {
            String[] commandParts = line.split(";");
            String command = commandParts[0];
            String filterName = commandParts[1];
            String filterCriteria = commandParts[2];
            
            switch (command) {
                case "Add filter":
                    commandLines.add(line);
                    break;
                case "Remove filter":
                    String commandToRemove = "Add filter;" + filterName + ";" + filterCriteria;
                    commandLines.removeIf(s -> s.equals(commandToRemove));
                    break;
            }
            line = scanner.nextLine();
        }

        for (String command : commandLines) {
            String[] commandParts = command.split(";");
            String filterName = commandParts[1];
            String filterCriteria = commandParts[2];

            Predicate<String> startsWith = name -> name.startsWith(filterCriteria);
            Predicate<String> endsWith = name -> name.endsWith(filterCriteria);
            Predicate<String> length = name -> name.length() == Integer.parseInt(filterCriteria);
            Predicate<String> contains = name -> name.contains(filterCriteria);

            switch (filterName) {
                case "Starts with":
                    peopleList.removeIf(startsWith);
                    break;
                case "Ends with":
                    peopleList.removeIf(endsWith);
                    break;
                case "Length":
                    peopleList.removeIf(length);
                    break;
                case "Contains":
                    peopleList.removeIf(contains);
                    break;


            }
        }

        System.out.println(peopleList.stream().collect(Collectors.joining(" ")).toString().replaceAll("([\\[\\]])", ""));
        
    }
    
}
