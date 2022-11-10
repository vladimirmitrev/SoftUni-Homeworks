package exam05_23Oct2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class P01AutumnCocktails2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bucketQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(bucketQueue::offer);

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(freshnessStack::push);

        TreeMap<String, Integer> cocktailMap = new TreeMap<>();
        cocktailMap.put("Pear Sour", 0);
        cocktailMap.put("The Harvest", 0);
        cocktailMap.put("Apple Hinny", 0);
        cocktailMap.put("High Fashion", 0);

        while (!bucketQueue.isEmpty() && !freshnessStack.isEmpty()) {
                int bucketValue = bucketQueue.peek();
                int freshnessValue = freshnessStack.peek();
            if(bucketValue == 0) {
                bucketQueue.poll();
                continue;
            }
            int sum = bucketValue * freshnessValue;
            bucketQueue.poll();
            freshnessStack.pop();

            switch (sum) {
                case 150:
                    cocktailMap.put("Pear Sour", cocktailMap.get("Pear Sour") + 1);
                    break;
                case 250:
                    cocktailMap.put("The Harvest", cocktailMap.get("The Harvest") + 1);
                    break;
                case 300:
                    cocktailMap.put("Apple Hinny", cocktailMap.get("Apple Hinny") + 1);
                    break;
                case 400:
                    cocktailMap.put("High Fashion", cocktailMap.get("High Fashion") + 1);
                    break;
                default:
                    bucketQueue.addLast(bucketValue + 5);
                    break;
            }
        }
        boolean allCocktailsMade = cocktailMap.entrySet().stream().allMatch(el -> el.getValue() > 0);

        if(allCocktailsMade) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int ingredientsLeft = 0;

        if(!bucketQueue.isEmpty()) {
            for (Integer item : bucketQueue) {
                ingredientsLeft += item;
            }
            System.out.printf("Ingredients left: %d%n", ingredientsLeft);
        }
        cocktailMap.entrySet().stream()
                .filter(el -> el.getValue() > 0)
                .forEach(e -> System.out.printf(" # %s --> %d%n", e.getKey(), e.getValue() ));

    }
}
