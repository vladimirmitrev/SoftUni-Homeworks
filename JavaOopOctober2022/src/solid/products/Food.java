package solid.products;

public abstract class Food {

    private double grams;

    public Food(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    double getFoodAmountInKilograms(){
        return 1000 / this.grams;
    }

}
