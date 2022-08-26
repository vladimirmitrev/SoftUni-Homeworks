package objectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06VehicleCatalogue {
    static class Vehicles {
        private String type;
        private String make;
        private String color;
        private int horsepower;

        public Vehicles(String type, String make, String color, int horsepower) {
            this.type = type;
            this.make = make;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return this.type;
        }

        public String getMake() {
            return this.make;
        }

        public String getColor() {
            return this.color;
        }

        public int getHorsepower() {
            return this.horsepower;
        }

        @Override
        public String toString() {
            String formattedType = "";
            if (this.type.equals("car")) {
                formattedType = "Car";
            } else if (this.type.equals("truck")) {
                formattedType = "Truck";
            }

            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                    formattedType, this.make, this.color, this.horsepower);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicles> vehiclesList = new ArrayList<>();
        while (!input.equals("End")) {
            String[] vehicleData = input.split(" ");
            String type = vehicleData[0];
            String make = vehicleData[1];
            String color = vehicleData[2];
            int horsePower = Integer.parseInt(vehicleData[3]);

            Vehicles vehicles = new Vehicles(type, make, color, horsePower);
            vehiclesList.add(vehicles);

            input = scanner.nextLine();
        }
        String inputMake = scanner.nextLine();

        while (!inputMake.equals("Close the Catalogue")) {

            for (Vehicles vehicles : vehiclesList) {
                if (inputMake.equals(vehicles.getMake())) {
                    System.out.println(vehicles);
                    break;
                }
            }
            inputMake = scanner.nextLine();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", getAverageHP(vehiclesList, "cars"));
        System.out.printf("Trucks have average horsepower of: %.2f.%n", getAverageHP(vehiclesList, "trucks"));

    }

    private static double getAverageHP(List<Vehicles> vehiclesList, String type) {
        double sum = 0;
        int count = 0;
        if (type.equals("cars")) {
            for (Vehicles vehicle : vehiclesList) {
                if (vehicle.getType().equals("car")) {
                    sum += vehicle.getHorsepower();
                    count++;
                }
            }
        } else if (type.equals("trucks")) {
            for (Vehicles vehicle : vehiclesList) {
                if (vehicle.getType().equals("truck")) {
                    sum += vehicle.getHorsepower();
                    count++;
                }
            }
        }
        if (sum == 0) {
            return 0;
        }
        return sum / count;
    }
}
