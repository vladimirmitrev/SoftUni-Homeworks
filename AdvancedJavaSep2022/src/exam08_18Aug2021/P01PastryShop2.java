package exam08_18Aug2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01PastryShop2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(liquidsQueue::offer);

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(ingredientsStack::push);

        LinkedHashMap<String, Integer> foodMap = new LinkedHashMap<>();
        foodMap.put("Biscuit", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pie", 0);
        foodMap.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquidValue = liquidsQueue.poll();
            int ingredientsValue = ingredientsStack.pop();
            int sum = liquidValue + ingredientsValue;

            switch (sum) {
                case 25:
                    foodMap.put("Biscuit", foodMap.get("Biscuit") + 1);
                    break;
                case 50:
                    foodMap.put("Cake", foodMap.get("Cake") + 1);
                    break;
                case 75:
                    foodMap.put("Pastry", foodMap.get("Pastry") + 1);
                    break;
                case 100:
                    foodMap.put("Pie", foodMap.get("Pie") + 1);
                    break;
                default:
                    ingredientsStack.push(ingredientsValue + 3);
                    break;
            }
        }
        boolean allFoodCooked = foodMap.entrySet().stream().allMatch(food -> food.getValue() > 0);

        System.out.println(allFoodCooked ? "Great! You succeeded in cooking all the food!" :
                "What a pity! You didn't have enough materials to cook everything.");

        String liquidsLeft = liquidsQueue.isEmpty() ? "none" :
                liquidsQueue.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));

        System.out.println("Liquids left: " + liquidsLeft);

        String ingredientsLeft = ingredientsStack.isEmpty() ? "none" :
                ingredientsStack.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));

        System.out.println("Ingredients left: " + ingredientsLeft);

        foodMap.entrySet().forEach(cake -> System.out.printf("%s: %d%n", cake.getKey(), cake.getValue()));

    }
}
