package inheritanceExercise.restaurant;

import java.math.BigDecimal;

public class Food extends Product{
    private double grams;

    public double getGrams() {
        return grams;
    }

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }

}
