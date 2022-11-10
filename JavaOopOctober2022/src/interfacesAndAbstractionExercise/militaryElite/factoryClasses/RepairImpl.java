package interfacesAndAbstractionExercise.militaryElite.factoryClasses;

import interfacesAndAbstractionExercise.militaryElite.interfaces.Repair;

public class RepairImpl implements Repair {

    private final String name;
    private final int hoursWorked;

    public RepairImpl(String name, int hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getName(), this.getHoursWorked());
    }
}
