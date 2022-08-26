package programming03FundamentalsFinalExamRetake;

import java.util.*;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\|");
            String carName = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            carsMap.putIfAbsent(carName, new ArrayList<>());
            carsMap.get(carName).add(0, mileage);
            carsMap.get(carName).add(1, fuel);
        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];
            String carName = tokens[1];
            int currentFuel = carsMap.get(carName).get(1);
            int currentMileage = carsMap.get(carName).get(0);

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuelNeeded = Integer.parseInt(tokens[3]);

                    if (currentFuel >= fuelNeeded) {
                        int newMileage = currentMileage + distance;
                        int newFuel = currentFuel - fuelNeeded;
                        currentMileage = newMileage;
                        carsMap.get(carName).set(0, newMileage);
                        carsMap.get(carName).set(1, newFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n"
                                , carName, distance, fuelNeeded);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if(currentMileage >= 100000) {
                        System.out.printf("Time to sell the %s!%n", carName);
                        carsMap.remove(carName);
                    }
                    break;
                case "Refuel":
                    int refillFuel = Integer.parseInt(tokens[2]);
                    int newFuel = currentFuel + refillFuel;
                    int fuelDiff = 0;
                    if(newFuel > 75) {
                        fuelDiff = 75 - currentFuel;
                        newFuel = 75;
                    } else {
                        fuelDiff = refillFuel;
                    }
                    carsMap.get(carName).set(1, newFuel);
                    System.out.printf("%s refueled with %d liters%n", carName, fuelDiff);
                    break;
                case "Revert":
                    int kilometersToRevert = Integer.parseInt(tokens[2]);
                    int newMileage = currentMileage - kilometersToRevert;

                    if(newMileage < 10000) {
                        newMileage = 10000;
                    } else {

                        System.out.printf("%s mileage decreased by %d kilometers%n", carName, kilometersToRevert);
                    }
                    carsMap.get(carName).set(0, newMileage);

                    break;
            }

            input = scanner.nextLine();
        }

        carsMap.entrySet().forEach(entry ->
                System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n"
                        , entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
