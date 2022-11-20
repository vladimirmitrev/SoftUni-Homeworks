package DesignPatternsExercise.factoryExercise.cakes;

public class CakeFactory {

    public static Cake createCake(String cakeType) {
        Cake cake = null;

        switch (cakeType) {
            case "Spinach":
                cake = new SpinachCake(12, 20, 8);
                break;
            case "Chocolate":
                cake = new ChocolateCake(14, 24, 12);
                break;
            case "Biscuit":
                cake = new BisquitCake(16, 28, 16);
                break;
            default:
                System.out.println("Invalid Cake Type");
        }
        return cake;
    }
}
