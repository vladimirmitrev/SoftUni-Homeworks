package DesignPatternsExercise.factoryExercise;

import DesignPatternsExercise.factoryExercise.cakes.Cake;
import DesignPatternsExercise.factoryExercise.cakes.CakeFactory;

public class PastryShop {

    public static Cake orderCake(String cakeType) {
        Cake cake = CakeFactory.createCake(cakeType);
        cake.prepare();
        cake.bake();
        cake.box();

        return cake;
    }
}
