package interfacesAndAbstractionLab.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiableList = new ArrayList<>();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            Identifiable identifiable = tokens.length == 2
                    ? new Robot(tokens[0], tokens[1])
                    : new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

            identifiableList.add(identifiable);

            input = scanner.nextLine();
        }

        String fakeIdPostFix = scanner.nextLine();

        identifiableList
                .stream()
                .map(Identifiable::getId)
                .filter(e -> e.endsWith(fakeIdPostFix))
                .forEach(System.out::println);

    }
}
