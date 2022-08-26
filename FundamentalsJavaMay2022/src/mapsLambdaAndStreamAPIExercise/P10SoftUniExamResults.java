package mapsLambdaAndStreamAPIExercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.Entry.comparingByValue;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> languageCount = new LinkedHashMap<>();
        Map<String, Integer> userPoints = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String[] splitArray = input.split("-");
            String username = splitArray[0];
            if(splitArray.length == 3) {
                String language = splitArray[1];
                int points = Integer.parseInt(splitArray[2]);

                if(!userPoints.containsKey(username)) {
                    userPoints.put(username, points);
                } else {
                    int currentPoints = userPoints.get(username);
                    if(points > currentPoints) {
                        userPoints.put(username, points);
                    }
                }
                if(!languageCount.containsKey(language)) {
                    languageCount.put(language, 1);
                } else {
                    languageCount.put(language, languageCount.get(language) + 1);
                }

            }  else {
                userPoints.remove(username);
            }

            input = scanner.nextLine();
        }


        System.out.println("Results:");
        userPoints.entrySet()
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));

        System.out.println("Submissions:");
        languageCount.entrySet()
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
