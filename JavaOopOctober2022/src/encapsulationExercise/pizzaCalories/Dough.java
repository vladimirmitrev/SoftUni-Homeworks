package encapsulationExercise.pizzaCalories;

import java.util.Arrays;

public class Dough {
    private DoughModifier flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setWeight(weight);
        setBakingTechnique(bakingTechnique);
    }

    private void setFlourType(String flourType) {
        boolean flourExist = Arrays.stream(DoughModifier.values()).anyMatch(d -> d.name().equals(flourType));
        if (flourExist) {
            this.flourType = DoughModifier.valueOf(flourType);
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!"Crispy".equals(bakingTechnique)
                && !"Chewy".equals(bakingTechnique)
                && !"Homemade".equals(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * getFlourTypeModifier() * getBakingTechniqueModifier();
    }

    private double getBakingTechniqueModifier() {
        switch (bakingTechnique) {
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1.0;
        }
        return 0;
    }

    private double getFlourTypeModifier() {
        return flourType.getModifier();
    }
}
