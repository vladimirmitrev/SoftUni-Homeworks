package interfacesAndAbstractionExercise.militaryEliteVM;

public enum State {
    InProgress("inProgress"),
    Finished("Finished");


    private String state;

    State(String state) {
        this.state = state;
    }


    public String getState() {
        return state;
    }
    public static boolean isValidState(String state) {
        return state.equals(InProgress.getState()) || state.equals(Finished.getState());
    }
}
