package DesignPatternsExercise.commandExaple;

public class Main {
    public static void main(String[] args) {

        TVRemote tvRemote = new TVRemote(12, "HBO");

        VolumeUpCommand volumeUp = new VolumeUpCommand(tvRemote);

        VolumeDownCommand volumeDown = new VolumeDownCommand(tvRemote);

        volumeUp.execute();
        volumeUp.execute();
        volumeUp.execute();

        volumeDown.execute();
        volumeDown.execute();

    }
}
