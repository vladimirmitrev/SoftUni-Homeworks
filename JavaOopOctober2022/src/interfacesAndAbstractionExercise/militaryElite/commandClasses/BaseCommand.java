package interfacesAndAbstractionExercise.militaryElite.commandClasses;

import interfacesAndAbstractionExercise.militaryElite.interfaces.Command;
import interfacesAndAbstractionExercise.militaryElite.interfaces.Soldier;

import java.util.List;

public abstract class BaseCommand implements Command {

    private final List<Soldier> soldiers;

    protected BaseCommand(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    protected List<Soldier> getSoldier() {
        return this.soldiers;
    }

    public void add(Soldier soldier) {
        this.soldiers.add(soldier);
    }
}
