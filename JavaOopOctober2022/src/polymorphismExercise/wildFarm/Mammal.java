package polymorphismExercise.wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    protected String livingRegion;
    protected DecimalFormat df = new DecimalFormat("#.##");


    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                getAnimalType(),
                animalName,
                df.format(animalWeight),
                livingRegion,
                foodEaten);
    }
}
