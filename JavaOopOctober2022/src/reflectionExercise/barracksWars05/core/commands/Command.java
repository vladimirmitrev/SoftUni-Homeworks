package reflectionExercise.barracksWars05.core.commands;

import reflectionExercise.barracksWars05.interfaces.Executable;

public abstract class Command implements Executable {

    final private String[] data;


    protected Command(String[] data) {
        this.data = data;

    }

    protected String[] getData() {
        return this.data;
    }
}

