package DesignPatternsExercise.factoryExercise.cakes;

public class BisquitCake extends Cake{

    public BisquitCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Biscuit Cake");
    }

    @Override
    public void bake() {
        System.out.println("Baking Biscuit Cake");
    }

    @Override
    public void box() {
        System.out.println("Boxing Biscuit Cake");
    }
}
