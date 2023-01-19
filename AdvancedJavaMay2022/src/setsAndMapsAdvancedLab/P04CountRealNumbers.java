package setsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble)
                .forEach(key -> {

//                    *1 variant
//                    if(numbersMap.containsKey(key)) {
//                        int oldCount = numbersMap.get(key);
//                        int newCount = oldCount + 1;
//                        numbersMap.put(key, newCount);
//                    } else {
//                        numbersMap.put(key, 1);
//                    }

                   // *2 Variant
//                    Integer oldCount = numbersMap.get(key);
//                    int newValue = 1;
//                    if(oldCount != null) {
//                        newValue += oldCount;
//                    }
//                    numbersMap.put(key, newValue);

//                  //*3 variant
                  numbersMap.putIfAbsent(key, 0);
                  int oldCount = numbersMap.get(key);
                  int newCount = oldCount + 1;
                  numbersMap.put(key, newCount);

                });

        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
