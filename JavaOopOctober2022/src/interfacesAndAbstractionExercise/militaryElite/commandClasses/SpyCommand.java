package interfacesAndAbstractionExercise.militaryElite.commandClasses;

import interfacesAndAbstractionExercise.militaryElite.factoryClasses.SoldierFactory;
import interfacesAndAbstractionExercise.militaryElite.interfaces.Soldier;

import java.util.List;

public class SpyCommand extends BaseCommand {
    public SpyCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.produceSpy(args));
    }
}
