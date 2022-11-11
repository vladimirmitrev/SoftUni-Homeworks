package reflectionExercise.barracksWars04;

import reflectionExercise.barracksWars04.core.Engine;
import reflectionExercise.barracksWars04.core.factories.UnitFactoryImpl;
import reflectionExercise.barracksWars04.data.UnitRepository;
import reflectionExercise.barracksWars04.interfaces.Repository;
import reflectionExercise.barracksWars04.interfaces.Runnable;
import reflectionExercise.barracksWars04.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
