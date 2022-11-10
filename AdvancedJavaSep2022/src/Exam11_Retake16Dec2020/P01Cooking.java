package Exam11_Retake16Dec2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(liquidsQueue::offer);

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(ingredientsStack::push);

        TreeMap<String, Integer> foodMap = new TreeMap<>();
        foodMap.put("Bread", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pastry", 0);
        foodMap.put("Fruit Pie", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquidValue = liquidsQueue.poll();
            int ingredientsValue = ingredientsStack.pop();
            int sum = liquidValue + ingredientsValue;

            switch (sum) {
                case 25:
                    foodMap.put("Bread", foodMap.get("Bread") + 1);
                    break;
                case 50:
                    foodMap.put("Cake", foodMap.get("Cake") + 1);
                    break;
                case 75:
                    foodMap.put("Pastry", foodMap.get("Pastry") + 1);
                    break;
                case 100:
                    foodMap.put("Fruit Pie", foodMap.get("Fruit Pie") + 1);
                    break;
                default:
                    ingredientsStack.push(ingredientsValue + 3);
                    break;
            }
        }

        boolean cookAllFoods = foodMap.entrySet().stream().allMatch(element -> element.getValue() > 0);

        if (cookAllFoods) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        String remainingLiquids = liquidsQueue.isEmpty() ? "none" : liquidsQueue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Liquids left: " + remainingLiquids);

        String remainingIngredients = ingredientsStack.isEmpty() ? "none" : ingredientsStack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Ingredients left: " + remainingIngredients);

        foodMap.entrySet().forEach(element -> System.out.printf("%s: %d%n", element.getKey(), element.getValue()));

    }
}
