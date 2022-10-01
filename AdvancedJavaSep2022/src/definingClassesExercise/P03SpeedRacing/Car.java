package definingClassesExercise.P03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double consumption;
    private int distance;

    public Car(String model, double fuelAmount, double consumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumption = consumption;
        this.distance = 0;
    }

    public boolean enoughFuel(int kilometers) {
        double fuelNeeded = calculateNeededFuel(kilometers);
        return fuelAmount >= fuelNeeded;
    }

    public void drive(int kilometers) {
        double fuelNeed = calculateNeededFuel(kilometers);
        fuelAmount -= fuelNeed;
        distance += kilometers;

    }
    public double calculateNeededFuel(int kilometers) {
        return kilometers * consumption;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);

    }
}
