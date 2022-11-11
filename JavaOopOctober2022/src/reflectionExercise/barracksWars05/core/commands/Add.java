package reflectionExercise.barracksWars05.core.commands;

import jdk.jshell.spi.ExecutionControl;
import reflectionExercise.barracksWars05.annotations.Inject;
import reflectionExercise.barracksWars05.interfaces.Repository;
import reflectionExercise.barracksWars05.interfaces.Unit;
import reflectionExercise.barracksWars05.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {
    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException,
            ClassNotFoundException,
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {

        final String unitType = getData()[1];

        final Unit unitToAdd = this.unitFactory.createUnit(unitType);

        this.repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
