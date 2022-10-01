package setsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        LinkedHashMap<String, String> emailsMap = new LinkedHashMap<>();

        while (!name.equals("stop")) {

            String email = scanner.nextLine();

            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                emailsMap.put(name, email);
            }

            name = scanner.nextLine();
        }
        for (Map.Entry<String, String> names : emailsMap.entrySet()) {
                    System.out.printf("%s -> %s%n", names.getKey(), names.getValue());
        }

    }
}
