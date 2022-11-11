package reflectionExercise.barracksWars05;

import reflectionExercise.barracksWars05.core.CommandInterpreterImpl;
import reflectionExercise.barracksWars05.core.Engine;
import reflectionExercise.barracksWars05.core.factories.UnitFactoryImpl;
import reflectionExercise.barracksWars05.data.UnitRepository;
import reflectionExercise.barracksWars05.interfaces.CommandInterpreter;
import reflectionExercise.barracksWars05.interfaces.Repository;
import reflectionExercise.barracksWars05.interfaces.Runnable;
import reflectionExercise.barracksWars05.interfaces.UnitFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        final Repository repository = new UnitRepository();

        final UnitFactory unitFactory = new UnitFactoryImpl();

        final CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        try {
            engine.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
