package polymorphismExercise.vehicles;

public class Car extends Vehicle {

    private final static double ADDITIONAL_AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double fuelTankCapacity) {
        super(fuelQuantity, fuelConsumption, fuelTankCapacity);
        this.fuelConsumption = this.fuelConsumption + ADDITIONAL_AC_CONSUMPTION;
    }
}
