package exam05_23Oct2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(ingredientsQueue::offer);

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(freshnessStack::push);

        TreeMap<String, Integer> cocktailsMap = new TreeMap<>();

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredientsValue = ingredientsQueue.peek();
            int freshnessValue = freshnessStack.peek();
            int sum = freshnessValue * ingredientsValue;
            if (ingredientsValue == 0) {
                ingredientsQueue.poll();
            } else if (sum == 150) {
                cocktailsMap.put("Pear Sour",
                        cocktailsMap.containsKey("Pear Sour") ? cocktailsMap.get("Pear Sour") + 1 : 1);
                freshnessStack.pop();
                ingredientsQueue.poll();
            } else if (sum == 250) {
                cocktailsMap.put("The Harvest",
                        cocktailsMap.containsKey("The Harvest") ? cocktailsMap.get("The Harvest") + 1 : 1);
                freshnessStack.pop();
                ingredientsQueue.poll();
            } else if (sum == 300) {
                cocktailsMap.put("Apple Hinny",
                        cocktailsMap.containsKey("Apple Hinny") ? cocktailsMap.get("Apple Hinny") + 1 : 1);
                freshnessStack.pop();
                ingredientsQueue.poll();
            } else if (sum == 400) {
                cocktailsMap.put("High Fashion",
                        cocktailsMap.containsKey("High Fashion") ? cocktailsMap.get("High Fashion") + 1 : 1);
                freshnessStack.pop();
                ingredientsQueue.poll();
            } else {
                freshnessStack.pop();
                ingredientsQueue.poll();
                ingredientsQueue.addLast(ingredientsValue + 5);
            }
        }
        if (cocktailsMap.size() >= 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()) {
            int sum = 0;
            for (Integer integer : ingredientsQueue) {

                sum += integer;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }
        cocktailsMap.entrySet().forEach(element -> {
            System.out.printf(" # %s --> %d%n", element.getKey(), element.getValue());
        });

    }
}
