package DesignPatternsExercise.commandExaple;

public class VolumeDownCommand implements Command {

    private TVRemote tvRemote;

    public VolumeDownCommand(TVRemote tvRemote) {
        this.tvRemote = tvRemote;
    }

    @Override
    public void execute() {
        int oldVolume = tvRemote.getVolume();
        tvRemote.setVolume(--oldVolume);
        System.out.println("New Volume is " + tvRemote.getVolume());
    }
}
