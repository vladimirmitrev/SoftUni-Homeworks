package exam04_13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(steelQueue::offer);

        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(carbonStack::push);

        TreeMap<String, Integer> swordsMap = new TreeMap<>();

        int totalForgedSwords = 0;
        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steelValue = steelQueue.poll();
            int carbonValue = carbonStack.pop();
            int sum = carbonValue + steelValue;

            switch (sum) {
                case 70:
                    swordsMap.put("Gladius", swordsMap
                            .containsKey("Gladius") ? swordsMap.get("Gladius") + 1 : 1);
                    totalForgedSwords++;
                    break;
                case 80:
                    swordsMap.put("Shamshir", swordsMap
                            .containsKey("Shamshir") ? swordsMap.get("Shamshir") + 1 : 1);
                    totalForgedSwords++;
                    break;
                case 90:
                    swordsMap.put("Katana", swordsMap
                            .containsKey("Katana") ? swordsMap.get("Katana") + 1 : 1);
                    totalForgedSwords++;
                    break;
                case 110:
                    swordsMap.put("Sabre", swordsMap
                            .containsKey("Sabre") ? swordsMap.get("Sabre") + 1 : 1);
                    totalForgedSwords++;
                    break;
                default:
                    carbonStack.push(carbonValue + 5);
                    break;
            }

        }
        if (totalForgedSwords > 0) {
            System.out.printf("You have forged %d swords.%n", totalForgedSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if(steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            String steelLeft = steelQueue.stream()
                    .map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Steel left: " + steelLeft);
        }

        if(carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            List<String> carbonLeft = carbonStack.stream()
                    .map(String::valueOf).collect(Collectors.toList());
            System.out.println("Carbon left: " + String.join(", ", carbonLeft));
        }

        if(!swordsMap.isEmpty()) {
            swordsMap.entrySet().forEach(sword -> System.out.printf("%s: %d%n", sword.getKey(), sword.getValue()));
        }
    }
}
