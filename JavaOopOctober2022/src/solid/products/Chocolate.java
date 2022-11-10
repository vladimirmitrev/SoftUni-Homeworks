package solid.products;

public class Chocolate extends Food implements Product{

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    public Chocolate(double grams) {
        super(grams);
    }

    @Override
    public double getAmountOfCalories() {

        return (CALORIES_PER_100_GRAMS / 100) * this.getGrams();
    }


}
