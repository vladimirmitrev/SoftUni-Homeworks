package mapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> items = new LinkedHashMap<>();

        while(!command.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if(!items.containsKey(command)) {
                    items.put(command, quantity);
            } else {
                int currentQuantity = items.get(command);
                items.put(command, currentQuantity + quantity);
            }

            command = scanner.nextLine();
        }
        items.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
