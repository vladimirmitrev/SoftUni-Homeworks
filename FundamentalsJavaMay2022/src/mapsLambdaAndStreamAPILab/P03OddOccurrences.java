package mapsLambdaAndStreamAPILab;

import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(" ");

        Map<String, Integer> wordsMap = new LinkedHashMap<>();
        for (int i = 0; i < inputLine.length; i++) {
            String currentWord = inputLine[i].toLowerCase();

            Integer count = wordsMap.get(currentWord);
            if (wordsMap.containsKey(currentWord)) {
                wordsMap.put(currentWord, count + 1);
            } else {
                wordsMap.put(currentWord, 1);
            }
        }
        List<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddWords.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", oddWords));
    }
}
