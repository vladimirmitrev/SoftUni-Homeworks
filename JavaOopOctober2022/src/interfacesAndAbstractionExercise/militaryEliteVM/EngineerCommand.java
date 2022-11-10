package interfacesAndAbstractionExercise.militaryEliteVM;

import java.util.List;

public class EngineerCommand extends BaseCommand{

    protected EngineerCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        if(Corps.isValidCorps(args.get(4))) {
            //super.add(Soldier);
        }
    }
}
