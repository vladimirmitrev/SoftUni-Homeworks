package reflectionExercise.barracksWars03;

import reflectionExercise.barracksWars03.core.Engine;
import reflectionExercise.barracksWars03.core.factories.UnitFactoryImpl;
import reflectionExercise.barracksWars03.data.UnitRepository;
import reflectionExercise.barracksWars03.interfaces.Repository;
import reflectionExercise.barracksWars03.interfaces.Runnable;
import reflectionExercise.barracksWars03.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
