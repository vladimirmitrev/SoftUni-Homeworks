    package exam04_13April2022;

    import java.util.ArrayDeque;
    import java.util.Arrays;
    import java.util.Scanner;
    import java.util.TreeMap;
    import java.util.stream.Collectors;

    public class P01Blacksmith02 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
            Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(steelQueue::offer);

            ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
            Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(carbonStack::push);

            TreeMap<String, Integer> swordsMap = new TreeMap<>();
            swordsMap.put("Gladius", 0);
            swordsMap.put("Shamshir", 0);
            swordsMap.put("Katana", 0);
            swordsMap.put("Sabre", 0);

            int totalSwords = 0;

            while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
                int steelValue = steelQueue.poll();
                int carbonValue = carbonStack.pop();
                int sum = carbonValue + steelValue;

                switch (sum) {
                    case 70:
                        swordsMap.put("Gladius", swordsMap.get("Gladius") + 1);
                        totalSwords++;
                        break;
                    case 80:
                        swordsMap.put("Shamshir", swordsMap.get("Shamshir") + 1);
                        totalSwords++;
                        break;
                    case 90:
                        swordsMap.put("Katana", swordsMap.get("Katana") + 1);
                        totalSwords++;
                        break;
                    case 110:
                        swordsMap.put("Sabre", swordsMap.get("Sabre") + 1);
                        totalSwords++;
                        break;
                    default:
                        carbonStack.push(carbonValue + 5);
                        break;
                }
            }


            if(totalSwords > 0) {
                System.out.printf("You have forged %d swords.%n", totalSwords);
            } else {
                System.out.println("You did not have enough resources to forge a sword.");
            }
            String steelLeft = steelQueue.isEmpty() ? "none" : steelQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));

            System.out.println("Steel left: " + steelLeft);

            String carbonLeft = carbonStack.isEmpty() ? "none" : carbonStack.stream().map(String::valueOf).collect(Collectors.joining(", "));

            System.out.println("Carbon left: " + carbonLeft);

            swordsMap.entrySet().stream()
                    .filter(e -> e.getValue() > 0)
                    .forEach(e -> System.out.printf("%s: %d%n", e.getKey(),e.getValue()));
        }
    }
