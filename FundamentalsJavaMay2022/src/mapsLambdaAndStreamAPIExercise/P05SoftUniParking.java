package mapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Map<String, String> registeredUsers = new LinkedHashMap<>();

        for (int i = 1; i <= n ; i++) {
            String commandLine = scanner.nextLine();
            String command = commandLine.split(" ")[0];
            String name = commandLine.split(" ")[1];

            switch (command) {
                case "register":
                    String licensePlate = commandLine.split(" ")[2];
                    if (registeredUsers.containsKey(name)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlate);
                    } else {
                        registeredUsers.put(name, licensePlate);
                        System.out.printf("%s registered %s successfully%n", name, licensePlate);
                    }
                    break;
                case "unregister":
                    if (!registeredUsers.containsKey(name)) {
                        System.out.printf("ERROR: user %s not found%n", name);
                    } else {
                        registeredUsers.remove(name);
                        System.out.printf("%s unregistered successfully%n", name);
                    }
                    break;
            }
        }
        registeredUsers.entrySet().forEach(entry -> System.out.printf("%s => %s%n", entry.getKey(), entry.getValue()));
    }
}
