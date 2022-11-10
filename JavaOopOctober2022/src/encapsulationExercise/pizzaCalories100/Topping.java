package encapsulationExercise.pizzaCalories100;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
      setToppingType(toppingType);
      setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(checkToppingIsInvalid(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
            return 2 * weight * getToppingModifier();
    }
    public boolean checkToppingIsInvalid(String toppingType) {
        return !"Meat".equals(toppingType) && !"Veggies".equals(toppingType) && !"Cheese".equals(toppingType) && !"Sauce".equals(toppingType);
    }

    private double getToppingModifier() {
        switch (toppingType) {
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
        }
        return 0;
    }

}
