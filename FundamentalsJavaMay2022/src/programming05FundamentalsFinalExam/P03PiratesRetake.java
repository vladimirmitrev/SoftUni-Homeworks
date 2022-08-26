package programming05FundamentalsFinalExam;

import java.util.*;

public class P03PiratesRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> townMap = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|\\|");
            String town = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            if (townMap.containsKey(town)) {
                int currentPopulation = townMap.get(town).get(0);
                int currentGold = townMap.get(town).get(1);
                townMap.get(town).set(0, currentPopulation + population);
                townMap.get(town).set(1, currentGold + gold);
            } else {
                townMap.putIfAbsent(town, new ArrayList<>());
                townMap.get(town).add(0, population);
                townMap.get(town).add(1, gold);
            }
            input = scanner.nextLine();
        }
        String secondInput = scanner.nextLine();

        while (!secondInput.equals("End")) {
            String[] tokens = secondInput.split("=>");
            String command = tokens[0];
            String town = tokens[1];
            int currentPopulation = townMap.get(town).get(0);
            int currentGold = townMap.get(town).get(1);
            int totalGold = 0;
            int totalPeople = 0;

            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(tokens[2]);
                    int gold = Integer.parseInt(tokens[3]);
                    currentPopulation -= people;
                    currentGold -= gold;
                    townMap.get(town).set(0, currentPopulation);
                    townMap.get(town).set(1, currentGold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                    if (currentPopulation <= 0 || currentGold <= 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        townMap.remove(town);
                    }
                    break;

                case "Prosper":
                    int goldGiven = Integer.parseInt(tokens[2]);

                    if (goldGiven <= 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        currentGold += goldGiven;
                        townMap.get(town).set(1, currentGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n"
                                , goldGiven, town, currentGold);
                    }
                    break;
            }
            secondInput = scanner.nextLine();
        }
        if(townMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townMap.size());

            townMap.forEach((key, value) ->
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n"
                            , key, value.get(0), value.get(1)));
        }
    }
}
