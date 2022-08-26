package programming02FundamentalsFinalExam02;

import java.util.*;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantsRarityMap = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRatingMap = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfPlants ; i++) {
            String plantInfo = scanner.nextLine();
            String plantName = plantInfo.split("<->")[0];
            int plantRarity = Integer.parseInt(plantInfo.split("<->")[1]);

            plantsRarityMap.put(plantName, plantRarity);
            plantsRatingMap.putIfAbsent(plantName, new ArrayList<>());
        }
        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] tokens  = input.split(": ");
            String command = tokens[0];
            String[] data = tokens[1].split(" - ");
            String name = data[0];

            if(!plantsRarityMap.containsKey(name)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }

            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(data[1]);
                    plantsRatingMap.get(name).add(rating);
                    break;

                case "Update":

                    int newRarity = Integer.parseInt(data[1]);
                    plantsRarityMap.put(name, newRarity);
                    break;

                case "Reset":
                    plantsRatingMap.get(name).clear();
                    break;
                default:
                    System.out.println("error");
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        plantsRarityMap.entrySet().forEach(entry -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                entry.getKey(), entry.getValue(), plantsRatingMap.get(entry.getKey())
                        .stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
    }
}
