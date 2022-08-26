package programming05FundamentalsFinalExam;

import java.util.*;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> townsMap = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|\\|");
            String townToAdd = tokens[0];
            int givenPopulation = Integer.parseInt(tokens[1]);
            int givenGold = Integer.parseInt(tokens[2]);

            if(!townsMap.containsKey(townToAdd)) {
                townsMap.put(townToAdd, new ArrayList<>());
                townsMap.get(townToAdd).add(0, givenPopulation);
                townsMap.get(townToAdd).add(1, givenGold);
            } else {
                int currentPopulation = townsMap.get(townToAdd).get(0);
                int currentGold = townsMap.get(townToAdd).get(1);
                townsMap.get(townToAdd).set(0, currentPopulation + givenPopulation);
                townsMap.get(townToAdd).set(1, currentGold + givenGold);
            }

            input = scanner.nextLine();
        }
        String commandLine = scanner.nextLine();

        while (!commandLine.equals("End")) {
            String[] tokens = commandLine.split("=>");
            String command = tokens[0];
            String townToAction = tokens[1];

            switch (command) {
                case "Plunder":
                    int peopleKilled = Integer.parseInt(tokens[2]);
                    int goldSteal = Integer.parseInt(tokens[3]);
                    int currentPeople = townsMap.get(townToAction).get(0);
                    int currentGold = townsMap.get(townToAction).get(1);

                    townsMap.get(townToAction).set(0 , currentPeople - peopleKilled);
                    townsMap.get(townToAction).set(1 , currentGold - goldSteal);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n"
                            , townToAction, goldSteal, peopleKilled );

                    if(currentPeople - peopleKilled <= 0 || currentGold - goldSteal <= 0) {

                        System.out.printf("%s has been wiped off the map!%n", townToAction);
                        townsMap.remove(townToAction);
                    }

                    break;
                case "Prosper":
                    int goldToAdd = Integer.parseInt(tokens[2]);
                    int gold = townsMap.get(townToAction).get(1);

                    if(goldToAdd >= 0) {
                        townsMap.get(townToAction).set(1 , gold + goldToAdd);
                        int totalGold = townsMap.get(townToAction).get(1);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n"
                                , goldToAdd, townToAction, totalGold);
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }

                    break;
            }

            commandLine = scanner.nextLine();
        }
        if(townsMap.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townsMap.size());

            for (Map.Entry<String, List<Integer>> entry : townsMap.entrySet()) {
                String town = entry.getKey();
                int population = entry.getValue().get(0);
                int gold = entry.getValue().get(1);

                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", town, population, gold);
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}