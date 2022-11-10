package interfacesAndAbstractionExercise.militaryElite.commandClasses;

import interfacesAndAbstractionExercise.militaryElite.enumeration.Corps;
import interfacesAndAbstractionExercise.militaryElite.factoryClasses.SoldierFactory;
import interfacesAndAbstractionExercise.militaryElite.interfaces.Soldier;

import java.util.List;

public class EngineerCommand extends BaseCommand {


    public EngineerCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        if (Corps.isValidCorps(args.get(4))) {
            super.add(SoldierFactory.produceEngineer(args));
        }
    }
}
