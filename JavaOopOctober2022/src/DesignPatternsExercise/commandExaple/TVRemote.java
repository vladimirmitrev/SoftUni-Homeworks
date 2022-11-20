package DesignPatternsExercise.commandExaple;

public class TVRemote {

    private int Volume;
    private String program;

    public TVRemote(int volume, String program) {
        Volume = volume;
        this.program = program;
    }


    public int getVolume() {
        return Volume;
    }

    public void setVolume(int volume) {
        Volume = volume;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
