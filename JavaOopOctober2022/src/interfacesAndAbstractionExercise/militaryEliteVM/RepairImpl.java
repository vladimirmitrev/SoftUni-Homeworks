package interfacesAndAbstractionExercise.militaryEliteVM;

public class RepairImpl implements Repair {

    private String name;
    private int workedHours;

    public RepairImpl(String name, int workedHours) {
        this.name = name;
        this.workedHours = workedHours;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHoursWorked() {
        return workedHours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", name, workedHours);
    }
}
