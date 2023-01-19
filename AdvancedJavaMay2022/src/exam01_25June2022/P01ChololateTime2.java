package exam01_25June2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class P01ChololateTime2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).forEach(milkQueue::offer);

        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).forEach(cacaoStack::push);

        TreeMap<String, Integer> chocolateMap = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milkValue = milkQueue.poll();
            double cacaoValue = cacaoStack.pop();
            double sum = milkValue + cacaoValue;
            double percentage = (cacaoValue / sum) * 100;

            if(percentage == 30) {
                chocolateMap.put("Milk Chocolate", chocolateMap.containsKey("Milk Chocolate")
                        ? chocolateMap.get("Milk Chocolate") + 1 : 1);

            } else if(percentage == 50) {
                chocolateMap.put("Dark Chocolate", chocolateMap.containsKey("Dark Chocolate")
                        ? chocolateMap.get("Dark Chocolate") + 1 : 1);

            } else if(percentage == 100) {
                chocolateMap.put("Baking Chocolate", chocolateMap.containsKey("Baking Chocolate")
                        ? chocolateMap.get("Baking Chocolate") + 1 : 1);

            } else {
                milkQueue.offer(milkValue + 10);
            }
        }


        if (chocolateMap.size() >= 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolateMap.entrySet().forEach(el -> System.out.printf("# %s --> %d%n", el.getKey(), el.getValue()));

    }

}
