package setsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> countryInfo = new LinkedHashMap<>();

        String input;
        while (!"report".equals(input = scanner.nextLine())) {
            String[] inputData = input.split("\\|");
            countryInfo.putIfAbsent(inputData[1], new LinkedHashMap<>());
            countryInfo.get(inputData[1]).putIfAbsent(inputData[0], Integer.parseInt(inputData[2]));
        }
        countryInfo.entrySet().stream().sorted((first, second) ->
                        Long.compare(second.getValue().values().stream().mapToLong(i -> i).sum()
                                , first.getValue().values().stream().mapToLong(i -> i).sum()))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n",
                            e.getKey(), e.getValue().values().stream().mapToLong(i -> i).sum());
                    e.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(entry -> System.out.printf("=>%s: %d%n", entry.getKey(), entry.getValue()));
                });
    }
}
