package definingClassesExercise.P03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carMap = new LinkedHashMap<>();
        for (int i = 0; i < countCars; i++) {
            String[] input = scanner.nextLine().split(" ");
            String carModel = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelPerKm = Double.parseDouble(input[2]);
            Car car = new Car(carModel, fuelAmount, fuelPerKm);
            carMap.put(carModel, car);

        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandParts = command.split(" ");
            String carModel = commandParts[1];
            int kilometersToDrive = Integer.parseInt(commandParts[2]);

            Car currentCar = carMap.get(carModel);

            if (!currentCar.enoughFuel(kilometersToDrive)) {
                System.out.println("Insufficient fuel for the drive");

            } else {
                currentCar.drive(kilometersToDrive);
            }
            command = scanner.nextLine();
        }

        carMap.values().stream().forEach(System.out::println);
    }
}
