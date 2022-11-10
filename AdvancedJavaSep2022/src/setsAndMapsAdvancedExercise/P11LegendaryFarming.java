package setsAndMapsAdvancedExercise;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> itemInfo = new TreeMap<>(){{put("shards",0);put("fragments",0);put("motes",0);}};
        Map<String, Integer> junkInfo = new TreeMap<>();
        String legendaryItem = "";

        while (legendaryItem.equals("")) {
            String[] input = scanner.nextLine().toLowerCase(Locale.ROOT).split("\\s+");
            for (int i = 1; i < input.length; i += 2) {
                if (input[i].equals("shards")||input[i].equals("fragments")||input[i].equals("motes")) {
                    itemInfo.put(input[i], itemInfo.get(input[i]) + Integer.parseInt(input[i - 1]));
                    if (itemInfo.get(input[i]) >= 250) {
                        switch (input[i]) {
                            case "shards":
                                legendaryItem = "Shadowmourne";
                                break;
                            case "fragments":
                                legendaryItem = "Valanyr";
                                break;
                            case "motes":
                                legendaryItem = "Dragonwrath";
                                break;
                        }
                        itemInfo.put(input[i], itemInfo.get(input[i]) - 250);
                        break;
                    }
                }else{
                    junkInfo.put(input[i], !junkInfo.containsKey(input[i])
                            ? Integer.parseInt(input[i - 1]) : junkInfo.get(input[i]) + Integer.parseInt(input[i - 1]));
                }
            }
        }
        System.out.println(legendaryItem + " obtained!");
        itemInfo.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(e ->
                System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
        junkInfo.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }
}
