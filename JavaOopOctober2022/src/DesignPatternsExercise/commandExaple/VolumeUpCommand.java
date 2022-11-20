package DesignPatternsExercise.commandExaple;

public class VolumeUpCommand implements Command {

    private TVRemote tvRemote;

    public VolumeUpCommand(TVRemote tvRemote) {
        this.tvRemote = tvRemote;
    }


    @Override
    public void execute() {
        int oldVolume = tvRemote.getVolume();
        tvRemote.setVolume(++oldVolume);
        System.out.println("New Volume is " + tvRemote.getVolume());
    }
}
