package reflectionExercise.barracksWars05.core.commands;

import jdk.jshell.spi.ExecutionControl;
import reflectionExercise.barracksWars05.annotations.Inject;
import reflectionExercise.barracksWars05.interfaces.Repository;

public class Retire extends Command {
    @Inject
    private Repository repository;


    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        final String unitType = super.getData()[1];

        this.repository.removeUnit(unitType);

        return unitType + " retired!";
    }
}
