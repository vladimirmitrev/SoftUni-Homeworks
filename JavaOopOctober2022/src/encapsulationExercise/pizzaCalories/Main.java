package encapsulationExercise.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split(" ");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        String[] doughData = scanner.nextLine().split(" ");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double pizzaWeight = Double.parseDouble(doughData[3]);

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            Dough dough = new Dough(flourType, bakingTechnique, pizzaWeight);
            pizza.setDough(dough);

            String command = scanner.nextLine();
            while(!"END".equals(command)) {
                String[] commandParts = command.split(" ");
                String toppingType = commandParts[1];
                double toppingWeight = Double.parseDouble(commandParts[2]);

                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);

                command = scanner.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

        } catch (IllegalArgumentException e ) {
            System.out.println(e.getMessage());
        }
    }
}
