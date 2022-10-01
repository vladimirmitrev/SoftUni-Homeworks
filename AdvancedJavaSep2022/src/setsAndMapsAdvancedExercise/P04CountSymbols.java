package setsAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        TreeMap<Character, Integer> symbolsMap = new TreeMap<>();

        for (int i = 0; i < inputLine.length(); i++) {
            char currentSymbol = inputLine.charAt(i);
            if (!symbolsMap.containsKey(currentSymbol)) {
                symbolsMap.put(currentSymbol, 1);
            } else {
                int currentCount = symbolsMap.get(currentSymbol);
                symbolsMap.put(currentSymbol, ++currentCount);
            }
        }
        for (Map.Entry<Character, Integer> character : symbolsMap.entrySet()) {
            System.out.printf("%c: %d time/s%n", character.getKey(), character.getValue());
        }
    }
}
