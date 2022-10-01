package definingClassesExercise.P07Google;

public class Car {
    private String carModel;
    private String carSpeed;

    public Car(String carModel, String carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String format() {
        return String.format("%s %s", carModel, carSpeed);
    }
}
