package definingClassesExercise.P04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCars = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < countCars; i++) {
            String[] inputLine = scanner.nextLine().split(" ");

            String carModel = inputLine[0];
            int engineSpeed = Integer.parseInt(inputLine[1]);
            int enginePower = Integer.parseInt(inputLine[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(inputLine[3]);
            String cargoType = inputLine[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tiresList = new ArrayList<>();
            for (int j = 5; j < inputLine.length ; j += 2) {
                double tirePressure = Double.parseDouble(inputLine[j]);
                int tireAge = Integer.parseInt(inputLine[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tiresList.add(tire);
            }
            Car car = new Car(carModel, engine, cargo, tiresList);
            carList.add(car);
        }

        String cargoType = scanner.nextLine();

        if(cargoType.equals("fragile")) {
            carList.stream().filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> car.getTires().stream()
                            .anyMatch(tire -> tire.getPressure() < 1))
                    .forEach(car -> System.out.println(car.getModel()));

        } else {
            carList.stream().filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));



        }

    }
}
