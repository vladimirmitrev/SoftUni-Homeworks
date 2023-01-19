package definingClassesExercise.P05CarSalesman;

public class Engine {
    //An Engine has a model, power, displacement, and efficiency.
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    public Engine(String engineModel, String enginePower) {
        this.power = enginePower;
        this.model = engineModel;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, String enginePower, String engineDisplacement) {
        this(engineModel, enginePower);
        this.displacement = engineDisplacement;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
