package polymorphismExercise.vehicles1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Vehicle car = createVehicle(tokens);

        tokens = scanner.nextLine().split("\\s+");
        Vehicle truck = createVehicle(tokens);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

       int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split("\\s+");

            String commandName = tokens[0];
            String vehicleType = tokens[1];

            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    String driveMessage = vehicles.get(vehicleType).drive(distance);
                    System.out.println(driveMessage);
                    break;

                case"Refuel":
                    double liters = Double.parseDouble(tokens[2]);
                    vehicles.get(vehicleType).refuel(liters);
                    break;
            }
        }
        vehicles.values().forEach(System.out::println);

    }

    private static Vehicle createVehicle(String[] tokens) {
        double fuelQty = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        String vehicleType = tokens[0];
        Vehicle vehicle = null;
        switch (vehicleType) {
            case "Car":
                vehicle =  new Car(fuelQty, fuelConsumption);
                break;
            case "Truck":
                vehicle =  new Truck(fuelQty, fuelConsumption);
                break;
        }
        return vehicle;
    }
}
