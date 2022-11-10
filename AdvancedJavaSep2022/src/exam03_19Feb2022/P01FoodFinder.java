package exam03_19Feb2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words  = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> vowelsQueue.offer(e.charAt(0)));

        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> consonantsStack.push(e.charAt(0)));


        int wordsFound = 0;

        while (!consonantsStack.isEmpty()) {
            char currentVowel = vowelsQueue.poll();
            char currentConsonant = consonantsStack.pop();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int indexVowel = word.indexOf(currentVowel);
                int indexConsonant = word.indexOf(currentConsonant);

                if(indexVowel >= 0) {
                    foundWords[i] = foundWords[i]
                            .substring(0, indexVowel) + currentVowel + foundWords[i].substring(indexVowel + 1);
                }
                if(indexConsonant >= 0) {
                    foundWords[i] = foundWords[i]
                            .substring(0, indexConsonant) + currentConsonant + foundWords[i].substring(indexConsonant + 1);
                }
            }
            vowelsQueue.offer(currentVowel);
        }
        List<String> output = Arrays.stream(foundWords)
                .filter(w -> !w.contains("*"))
                .collect(Collectors.toList());

        System.out.printf("Words found: %d%n", output.size());
        output.forEach(System.out::println);

    }
}
