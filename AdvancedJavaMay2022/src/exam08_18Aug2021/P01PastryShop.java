package exam08_18Aug2021;

import java.util.*;
import java.util.stream.Collectors;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(liquidsQueue::offer);

        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(ingredientStack::push);

        TreeMap<String, Integer> cakeMap = new TreeMap<>();
        cakeMap.put("Biscuit", 0);
        cakeMap.put("Cake", 0);
        cakeMap.put("Pastry", 0);
        cakeMap.put("Pie", 0);

        while (!liquidsQueue.isEmpty() && !ingredientStack.isEmpty()) {
            int liquidValue = liquidsQueue.poll();
            int ingredientsValue = ingredientStack.pop();
            int sum = liquidValue + ingredientsValue;

            if (sum == 25) {
                cakeMap.put("Biscuit", cakeMap.get("Biscuit") + 1);
            } else if (sum == 50) {
                cakeMap.put("Cake", cakeMap.get("Cake") + 1);
            } else if (sum == 75) {
                cakeMap.put("Pastry", cakeMap.get("Pastry") + 1);
            } else if (sum == 100) {
                cakeMap.put("Pie", cakeMap.get("Pie") + 1);
            } else {
                ingredientStack.push(ingredientsValue + 3);
            }
        }
        boolean allFoodsCooked = cakeMap.entrySet().stream().allMatch(e -> e.getValue() > 0);

        if (allFoodsCooked) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        String remainingLiquids = liquidsQueue.isEmpty() ? "none" : liquidsQueue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Liquids left: " + remainingLiquids);

        String remainingIngredients = ingredientStack.isEmpty() ? "none" : ingredientStack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Ingredients left: " + remainingIngredients);

        cakeMap.entrySet().forEach(element -> System.out.printf("%s: %d%n", element.getKey(),element.getValue()));

    }
}
