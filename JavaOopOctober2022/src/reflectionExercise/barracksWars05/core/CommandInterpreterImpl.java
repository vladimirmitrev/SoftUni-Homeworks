package reflectionExercise.barracksWars05.core;

import reflectionExercise.barracksWars05.annotations.Inject;
import reflectionExercise.barracksWars05.interfaces.CommandInterpreter;
import reflectionExercise.barracksWars05.interfaces.Executable;
import reflectionExercise.barracksWars05.interfaces.Repository;
import reflectionExercise.barracksWars05.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMAND_PACKAGE = "barracksWars.core.commands.";
    private final Repository repository;

    private final UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    @SuppressWarnings("all")
    public Executable interpretCommand(String[] data, String commandName) {

        final String finalCommandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);

        Executable executable = null;

        try {
            Class<? extends Executable> commandClass =
                    (Class<? extends Executable>) Class.forName(COMMAND_PACKAGE + finalCommandName);

            Constructor<? extends Executable> wantedConstructor =
                    commandClass.getDeclaredConstructor(String[].class);
            wantedConstructor.setAccessible(true);

            executable = wantedConstructor.newInstance(new Object[]{data});

            final Field[] wantedFields = executable.getClass().getDeclaredFields();

            final Field[] currentFields = this.getClass().getDeclaredFields();

            for (Field wantedField : wantedFields) {
                if (wantedField.isAnnotationPresent(Inject.class)) {
                    for (Field field : currentFields) {
                        if (wantedField.getType().equals(field.getType())) {
                            wantedField.setAccessible(true);
                            wantedField.set(executable, field.get(this));
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return executable;
    }
}
