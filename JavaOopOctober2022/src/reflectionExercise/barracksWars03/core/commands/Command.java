package reflectionExercise.barracksWars03.core.commands;

import reflectionExercise.barracksWars03.interfaces.Executable;
import reflectionExercise.barracksWars03.interfaces.Repository;
import reflectionExercise.barracksWars03.interfaces.UnitFactory;

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
