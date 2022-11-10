package polymorphismExercise.vehicles1;

public class Truck extends Vehicle {

    private final static double ADDITIONAL_AC_CONSUMPTION = 1.6;
    private final static double FUEL_TANK_REDUCTION = 0.95;


    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption = this.fuelConsumption + ADDITIONAL_AC_CONSUMPTION;
    }

    @Override
    public void refuel(double liters) {
        liters = liters * FUEL_TANK_REDUCTION;
        super.refuel(liters);
    }
}
