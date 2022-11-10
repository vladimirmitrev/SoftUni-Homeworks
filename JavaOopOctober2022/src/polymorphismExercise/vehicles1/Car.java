package polymorphismExercise.vehicles1;

public class Car extends Vehicle {

    private final static double ADDITIONAL_AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption = fuelConsumption + ADDITIONAL_AC_CONSUMPTION;
    }
}
