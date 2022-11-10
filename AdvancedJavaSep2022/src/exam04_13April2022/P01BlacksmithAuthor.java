package exam04_13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01BlacksmithAuthor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        Queue<Integer> steel = new ArrayDeque<>();
        Stack<Integer> carbon = new Stack<>();
        Arrays.stream(line1.split("\\s+")).map(Integer::parseInt).forEach(steel::offer);
        Arrays.stream(line2.split("\\s+")).map(Integer::parseInt).forEach(carbon::push);
        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Sabre", 0);
        swords.put("Katana", 0);
        swords.put("Shamshir", 0);
        swords.put("Gladius", 0);
        while (!steel.isEmpty() && !carbon.isEmpty()){
            int firstSt = steel.poll();
            int firstCarb = carbon.pop();
            if (firstCarb + firstSt == 70){
                swords.put("Gladius", swords.get("Gladius") + 1);
            }else if (firstCarb + firstSt == 80){
                swords.put("Shamshir", swords.get("Shamshir") + 1);
            }else if (firstCarb + firstSt == 90){
                swords.put("Katana", swords.get("Katana") + 1);
            }else if (firstCarb + firstSt == 110){
                swords.put("Sabre", swords.get("Sabre") + 1);
            }else {
                carbon.push(firstCarb + 5);
            }
        }
        int sum = swords.values().stream().mapToInt(Integer::intValue).sum();
        if (sum != 0) {
            System.out.printf("You have forged %d swords.%n", sum);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steel.isEmpty()){
            System.out.println("Steel left: none");
        } else {
            String collect = steel.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Steel left: " + collect);
        }
        if (carbon.isEmpty()){
            System.out.println("Carbon left: none");
        } else {
            List<String> collect = carbon.stream().map(String::valueOf).collect(Collectors.toList());
            Collections.reverse(collect);
            System.out.println("Carbon left: " + String.join(", ", collect));
        }
        swords.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .forEach(el -> System.out.println(el.getKey() + ": " + el.getValue()));
    }
}
