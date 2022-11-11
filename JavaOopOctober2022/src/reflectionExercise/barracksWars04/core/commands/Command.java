package reflectionExercise.barracksWars04.core.commands;

import reflectionExercise.barracksWars04.interfaces.Executable;
import reflectionExercise.barracksWars04.interfaces.Repository;
import reflectionExercise.barracksWars04.interfaces.UnitFactory;

public abstract class Command implements Executable {

    final private String[] data;
    final private Repository repository;
    final private UnitFactory unitFactory;

    protected Command(String[] data,
                   Repository repository,
                   UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

}
