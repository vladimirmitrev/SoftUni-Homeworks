package interfacesAndAbstractionExercise.militaryEliteVM;

import java.util.List;

public abstract class BaseCommand implements Command {

    private List<Soldier> soldiers;

    protected BaseCommand(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    protected List<Soldier> getSoldiers() {
        return soldiers;
    }
    public void add(Soldier soldier) {
        this.soldiers.add(soldier);
    }
}
