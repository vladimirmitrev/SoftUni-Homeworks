package reflectionExercise.barracksWars05.core.commands;

import reflectionExercise.barracksWars05.annotations.Inject;
import reflectionExercise.barracksWars05.interfaces.Repository;

public class Report extends Command {

    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
