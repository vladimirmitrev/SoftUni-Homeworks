package setsAndMapsAdvancedExercise;

import java.util.*;

public class P13DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<Double>>> statistic;
        statistic = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split(" ");
            String type = input[0] , name = input[1];
            double health = 250 , damage = 45 , armor = 10;

            if (!input[3].equals("null")) {
                health = Double.parseDouble(input[3]);
            }
            if (!input[2].equals("null")) {
                damage = Double.parseDouble(input[2]);
            }
            if (!input[4].equals("null")) {
                armor = Double.parseDouble(input[4]);
            }
            statistic.putIfAbsent(type, new TreeMap<>());
            double finalArmor = armor,finalHealth = health,finalDamage = damage;

            statistic.get(type).put(name, new ArrayList<>() {{
                add(0, finalDamage);
                add(1, finalHealth);
                add(2, finalArmor);
            }});
        }
        statistic.forEach((key1, value1) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n"
                    , key1
                    ,getAverage(value1.values(),0)
                    ,getAverage(value1.values(),1)
                    ,getAverage(value1.values(),2));
            value1.forEach((key, value) -> System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n"
                    , key, value.get(0), value.get(1), value.get(2)));
        });
    }

    private static Double getAverage(Collection<List<Double>> values, int i) {
        return values.stream().map(doubles -> doubles.get(i)).mapToDouble(Double::doubleValue).average().orElseThrow();
    }
}
