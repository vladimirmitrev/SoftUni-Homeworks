package interfacesAndAbstractionExercise.militaryElite.factoryClasses;

import interfacesAndAbstractionExercise.militaryElite.enumeration.State;
import interfacesAndAbstractionExercise.militaryElite.interfaces.Mission;

public class MissionImpl implements Mission {

    private final String codeName;
    private State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public void completeMission() {
        this.state = State.FINISHED;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state.getState();
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
