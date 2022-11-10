
package workingWithAbstractionExercise.greedyTimes;

import java.util.Scanner;
import static java.util.stream.DoubleStream.iterate;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");
        Bag bag = new Bag(capacity);

        iterate(0, i -> i < input.length, i -> i + 2).forEach(i -> {
            String item = input[(int) i].trim();
            long quantity = Long.parseLong(input[(int) (i + 1)].trim());
            if (item.length() == 3) {
                bag.addCash(item, quantity);
            } else if (item.toLowerCase().endsWith("gem")) {
                bag.addGem(item, quantity);
            } else if (item.equalsIgnoreCase("gold")) {
                bag.addGold(quantity);
            }
        });
        System.out.println(bag.ordered());

    }
}