package solid;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        CalorieCalculator calorieCalculator = new CalorieCalculator();
        Printer printer = new Printer();

        final double sum = calorieCalculator.sum(Collections.emptyList());
    }
}
