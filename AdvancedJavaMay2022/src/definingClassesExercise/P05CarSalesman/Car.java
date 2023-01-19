package definingClassesExercise.P05CarSalesman;

public class Car {
    //A Car has a model, engine, weight, and color.
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

        @Override
    public String toString() {
        Engine eng = this.getEngine();
        return String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s",
                this.model, eng.getModel(), eng.getPower(),eng.getDisplacement(), eng.getEfficiency(), this.weight, this.color);
    }

}

