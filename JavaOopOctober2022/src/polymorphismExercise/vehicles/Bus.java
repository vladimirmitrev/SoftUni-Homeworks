package polymorphismExercise.vehicles;

public class Bus extends Vehicle {
    public final static double ADDITIONAL_BUS_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double fuelTankCapacity) {
        super(fuelQuantity, fuelConsumption, fuelTankCapacity);
    }
}
