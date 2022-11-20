package DesignPatternsExercise.singleton.zooExample;

public class Owner {

    public void buyAnimals(String animalType, Integer count) {

        Zoo.getInstance().getAnimals().put(animalType, count);

    }

}
