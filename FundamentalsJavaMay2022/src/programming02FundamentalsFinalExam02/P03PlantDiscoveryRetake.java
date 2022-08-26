package programming02FundamentalsFinalExam02;

import java.util.*;

public class P03PlantDiscoveryRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantsRarityMap = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRating = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPlants ; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);
            plantsRarityMap.put(plant, rarity);
            plantsRating.putIfAbsent(plant, new ArrayList<>());
        }
        String input = scanner.nextLine();

        while (!input.equals("Exhibition")){
            String[] tokens = input.split(":");
            String command = tokens[0];
            String[] plants = input.split(" ");
            String plant = plants[1];

            if(!plantsRarityMap.containsKey(plant)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }

            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(plants[3]);
                    plantsRating.get(plant).add(rating);
                    break;

                case "Update":
                    int newRarity = Integer.parseInt(plants[3]);
                    plantsRarityMap.put(plant, newRarity);
                    break;
                case "Reset":
                    plantsRating.get(plant).clear();
                    break;
            }


         input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plantsRarityMap.entrySet().forEach(entry ->
                System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",entry.getKey(), entry.getValue(),
                        plantsRating.get(entry.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
    }
}
