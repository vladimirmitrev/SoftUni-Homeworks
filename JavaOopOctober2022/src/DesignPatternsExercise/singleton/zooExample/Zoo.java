package DesignPatternsExercise.singleton.zooExample;

import java.util.HashMap;

public class Zoo {

    private HashMap<String, Integer> animals;
    private static Zoo instance;

    private Zoo() {
        animals = new HashMap<>();
    }

    public HashMap<String, Integer> getAnimals() {
        return animals;
    }

    public static Zoo getInstance() {

        if(instance == null) {
            instance = new Zoo();
        }
        return instance;
    }
}
