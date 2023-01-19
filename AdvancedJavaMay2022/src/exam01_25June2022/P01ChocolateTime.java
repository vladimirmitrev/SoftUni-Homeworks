package exam01_25June2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class    P01ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .forEach(milkQueue::offer);

        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .forEach(cacaoStack::push);
        TreeMap<String, Integer> chocolatesMap = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milkValue = milkQueue.peek();
            double cacaoValue = cacaoStack.peek();
            double cacaoPercentage = cacaoValue / (milkValue + cacaoValue)  * 100;
            milkQueue.poll();
            cacaoStack.pop();
            if(cacaoPercentage == 30) {
                chocolatesMap.put("Milk Chocolate", chocolatesMap
                        .containsKey("Milk Chocolate") ? chocolatesMap.get("Milk Chocolate") + 1 : 1);
            } else if (cacaoPercentage == 50) {
                chocolatesMap.put("Dark Chocolate", chocolatesMap
                        .containsKey("Dark Chocolate") ? chocolatesMap.get("Dark Chocolate") + 1 : 1);

            } else if (cacaoPercentage == 100) {
                chocolatesMap.put("Baking Chocolate", chocolatesMap
                        .containsKey("Baking Chocolate") ? chocolatesMap.get("Baking Chocolate") + 1 : 1);
            } else {
                milkValue += 10;
                milkQueue.addLast(milkValue);
            }
        }
        if(chocolatesMap.size() >= 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        chocolatesMap.entrySet().forEach(e -> System.out.printf(" # %s --> %d%n", e.getKey(), e.getValue()));
    }
}
