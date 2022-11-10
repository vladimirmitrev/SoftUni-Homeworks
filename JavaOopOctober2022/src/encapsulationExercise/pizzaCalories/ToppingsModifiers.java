package encapsulationExercise.pizzaCalories;

public enum ToppingsModifiers {
    Meat(1.2),
    Veggies(0.8),
    Cheese(1.1),
    Sauce(0.9);
    private double modifier;

    ToppingsModifiers(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
}
