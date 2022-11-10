package interfacesAndAbstractionExercise.militaryElite.enumeration;

public enum State {

    INPROGRESS("inProgress"), FINISHED("finished");

    private final String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public static boolean isValidState(String state) {
        return state.equals(INPROGRESS.getState()) || state.equals(FINISHED.getState());
    }
}
