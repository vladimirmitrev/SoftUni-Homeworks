package interfacesAndAbstractionExercise.militaryEliteVM;

import java.util.List;

public class CommandoCommand extends BaseCommand{

    protected CommandoCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
            if(Corps.isValidCorps(args.get(4))) {
               // super.add(SoldierFactory.);
            }
    }
}
