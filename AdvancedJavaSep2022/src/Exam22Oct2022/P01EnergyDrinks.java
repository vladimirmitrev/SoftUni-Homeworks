package Exam22Oct2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeineMlStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(caffeineMlStack::push);

        ArrayDeque<Integer> energyDrinkQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(energyDrinkQueue::offer);

        int stamatsTotalCaffeine = 0;

        while (!caffeineMlStack.isEmpty() && !energyDrinkQueue.isEmpty()) {
            int caffeineValue = caffeineMlStack.pop();
            int energyDrinkValue = energyDrinkQueue.poll();
            int sum = caffeineValue * energyDrinkValue;

            if(sum <= 300) {
                if(stamatsTotalCaffeine + sum <= 300) {
                    stamatsTotalCaffeine += sum;
                } else {
                    stamatsTotalCaffeine -= 30;
                    energyDrinkQueue.offer(energyDrinkValue);
                }

            } else {
                energyDrinkQueue.offer(energyDrinkValue);
                if(stamatsTotalCaffeine - 30 >= 0) {
                    stamatsTotalCaffeine -= 30;
                }
            }
        }
        String drinksLeft = energyDrinkQueue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));


        if(energyDrinkQueue.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.println("Drinks left: " + drinksLeft);
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", stamatsTotalCaffeine);

    }
}
