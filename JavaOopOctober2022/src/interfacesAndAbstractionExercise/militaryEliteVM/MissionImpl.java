package interfacesAndAbstractionExercise.militaryEliteVM;

public class MissionImpl implements Mission {

    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public void completeMission() {
     //  this.state = State.Finished;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getState() {
        return this.state;
    }
    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
