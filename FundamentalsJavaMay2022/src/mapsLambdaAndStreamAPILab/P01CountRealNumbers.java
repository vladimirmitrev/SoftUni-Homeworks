package mapsLambdaAndStreamAPILab;


import java.util.*;
import java.util.stream.Collectors;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Double::parseDouble).collect(Collectors.toList());

        Map<Double, Integer> numbersMap = new TreeMap<>();

        for (Double currentNum : numbersList) {
            numbersMap.putIfAbsent(currentNum, 0);
            int currentValue = numbersMap.get(currentNum);
            numbersMap.put(currentNum, currentValue + 1);
        }
        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
