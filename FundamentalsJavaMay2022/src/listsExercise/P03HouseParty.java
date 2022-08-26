package listsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> guestNames = new ArrayList<>();

        for (int i = 1; i <= numberOfCommands ; i++) {
            String command = scanner.nextLine();

            List<String> commandParts = Arrays.stream(command.split(" "))
                                        .collect(Collectors.toList());
            String name = commandParts.get(0);

            if(commandParts.size() == 3) {
                if(guestNames.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guestNames.add(name);
                }
            } else if (commandParts.size() == 4) {
                    if(guestNames.contains(name)) {
                        guestNames.remove(name);
                    } else {
                        System.out.printf("%s is not in the list!%n", name);
                    }
            }

        }
        for (String name : guestNames) {
            System.out.println(name);
        }
    }
}
