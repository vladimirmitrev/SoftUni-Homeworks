package examPreparation012022.p01Cooking;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        TreeMap<String, Integer> foodMap = new TreeMap<>();
        foodMap.put("Bread", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pastry", 0);
        foodMap.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentIngredients = ingredients.pop();
            int sum = liquids.poll() + currentIngredients;
            String cookedFood;
            switch (sum) {
                case 25:
                    cookedFood = "Bread";
                    break;
                case 50:
                    cookedFood = "Cake";
                    break;
                case 75:
                    cookedFood = "Pastry";
                    break;
                case 100:
                    cookedFood = "Fruit Pie";
                    break;
                default:
                    cookedFood = null;
                    break;
            }
            if (cookedFood != null) {
                int newValue = foodMap.get(cookedFood) + 1;
                foodMap.put(cookedFood, newValue);
            } else {
                ingredients.push(currentIngredients + 3);
            }
        }
        boolean allFoodsCooked = foodMap.entrySet().stream().allMatch(e -> e.getValue() > 0);

        if (allFoodsCooked) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");

        }
        String remainingLiquids = liquids.isEmpty() ? "none" : liquids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Liquids left: " + remainingLiquids);

        String remainingIngredients = ingredients.isEmpty() ? "none" : ingredients.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Ingredients left: " + remainingIngredients);


        foodMap.entrySet().forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
