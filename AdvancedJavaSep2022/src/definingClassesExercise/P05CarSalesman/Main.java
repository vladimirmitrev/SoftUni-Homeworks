package definingClassesExercise.P05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        LinkedList<Engine> engineList = new LinkedList<>();
        LinkedList<Car> carList = new LinkedList<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] engineInput = scanner.nextLine().split("\\s+");
            String engineModel = engineInput[0];
            String enginePower = engineInput[1];

            Engine engine1 = null;
            switch (engineInput.length) {
                case 2:
                    engine1 = new Engine(engineModel, enginePower);

                    break;
                case 3:
                    if (engineInput[2].matches("\\d+")) {
                        String engineDisplacement = engineInput[2];
                        engine1 = new Engine(engineModel, enginePower, engineDisplacement);
                    } else {
                        String engineEfficiency = engineInput[2];
                        engine1 = new Engine(engineModel, enginePower, "n/a", engineEfficiency);
                    }

                    break;
                case 4:
                    String engineDisplacement = engineInput[2];
                    String engineEfficiency = engineInput[3];
                    engine1 = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
                    break;
            }
            engineList.add(engine1);

        }
        int carCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < carCount; i++) {
            String[] carInput = scanner.nextLine().split("\\s+");

            String carModel = carInput[0];
            String engineModelCar = carInput[1];

            Car car = null;
            Engine engine = null;

            for (Engine engine1 : engineList) {
                if (engine1.getModel().equals(engineModelCar)) {
                    engine = engine1;
                    break;
                }

            }

            switch (carInput.length) {
                case 2:

                    car = new Car(carModel, engine);

                    break;
                case 3:
                    if (carInput[2].matches("\\d+")) {
                        String carWeight = carInput[2];
                        car = new Car(carModel, engine, carWeight);
                    } else {
                        String carColor = carInput[2];
                        car = new Car(carModel, engine, "n/a", carColor);
                    }

                    break;
                case 4:
                    String carWeight = carInput[2];
                    String currentColor = carInput[3];
                    car = new Car(carModel, engine, carWeight, currentColor);
                    break;
            }
            carList.add(car);

        }
        for (Car car : carList) {
            System.out.println(car.toString());
        }

    }
}
