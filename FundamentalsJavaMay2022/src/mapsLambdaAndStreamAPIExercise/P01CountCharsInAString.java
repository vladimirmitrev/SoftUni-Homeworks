package mapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> charsCountMap = new LinkedHashMap<>();

        for (Character symbol : text.toCharArray()) {

            if(symbol == ' ') {
                continue;
            }

            if(!charsCountMap.containsKey(symbol)) {
                charsCountMap.put(symbol, 1);
            } else {
                int currentValue = charsCountMap.get(symbol);
                charsCountMap.put(symbol, currentValue + 1);
            }
        }
        charsCountMap.entrySet().
                forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}