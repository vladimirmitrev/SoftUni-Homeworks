package Exam13_28June2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(bombEffectsQueue::offer);

        ArrayDeque<Integer> bombCasingStacks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(bombCasingStacks::push);

        TreeMap<String, Integer> bombMap = new TreeMap<>();
        bombMap.put("Datura Bombs", 0);
        bombMap.put("Cherry Bombs", 0);
        bombMap.put("Smoke Decoy Bombs", 0);

        int datura = 0;
        int cherry = 0;
        int smoke = 0;

        while (!bombEffectsQueue.isEmpty() && !bombCasingStacks.isEmpty() && (datura < 3 || cherry < 3 || smoke < 3)) {
            int effectsValue = bombEffectsQueue.peek();
            int casingValue = bombCasingStacks.peek();
            int sum = effectsValue + casingValue;

            switch (sum) {
                case 40:
                    bombEffectsQueue.poll();
                    bombCasingStacks.pop();
                    bombMap.put("Datura Bombs", bombMap.get("Datura Bombs") + 1);
                    datura++;
                    break;

                case 60:
                    bombEffectsQueue.poll();
                    bombCasingStacks.pop();
                    bombMap.put("Cherry Bombs", bombMap.get("Cherry Bombs") + 1);
                    cherry++;
                    break;

                case 120:
                    bombEffectsQueue.poll();
                    bombCasingStacks.pop();
                    bombMap.put("Smoke Decoy Bombs", bombMap.get("Smoke Decoy Bombs") + 1);
                    smoke++;
                    break;

                default:
                    bombCasingStacks.pop();
                    bombCasingStacks.push(casingValue - 5);
                    break;
            }
        }
        boolean allBombsMade = bombMap.entrySet().stream().allMatch(element -> element.getValue() > 2);

        System.out.println(allBombsMade ? "Bene! You have successfully filled the bomb pouch!"
                : "You don't have enough materials to fill the bomb pouch.");

        String remainingEffect = bombEffectsQueue.isEmpty() ? "empty" : bombEffectsQueue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Bomb Effects: " + remainingEffect);

        String remainingCasing = bombCasingStacks.isEmpty() ? "empty" : bombCasingStacks.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Bomb Casings: " + remainingCasing);

        bombMap.entrySet().forEach(element -> System.out.printf("%s: %s%n", element.getKey(), element.getValue()));
    }
}
