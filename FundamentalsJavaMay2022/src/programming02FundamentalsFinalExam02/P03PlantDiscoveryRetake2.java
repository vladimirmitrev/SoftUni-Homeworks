package programming02FundamentalsFinalExam02;

import java.util.*;

public class P03PlantDiscoveryRetake2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> plantRarityMap = new LinkedHashMap<>();
        Map<String, List<Double>> plantRatingMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("<->");
            String plant = tokens[0];
            String rarity = tokens[1];

            plantRarityMap.put(plant, rarity);
            plantRatingMap.putIfAbsent(plant, new ArrayList<>());
        }
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            String[] data = input.split(" ");
            String plant = data[1];

            if(!plantRarityMap.containsKey(plant)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }

            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(data[3]);
                    plantRatingMap.get(plant).add(rating);

                    break;

                case "Update":
                    String newRarity = data[3];
                    plantRarityMap.put(plant, newRarity);

                    break;
                case "Reset":
                    plantRatingMap.get(plant).clear();

                    break;
            }

            input = scanner.nextLine();

        }
        System.out.println("Plants for the exhibition:");
        plantRarityMap.entrySet().forEach(entry ->
                System.out.printf("- %s; Rarity: %s; Rating: %.2f%n", entry.getKey(), entry.getValue(),
                        plantRatingMap.get(entry.getKey()).stream()
                                .mapToDouble(Double::doubleValue).average().orElse(0.0)));

    }
}
