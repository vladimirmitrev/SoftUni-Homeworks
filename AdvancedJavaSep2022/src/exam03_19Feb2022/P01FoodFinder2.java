package exam03_19Feb2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01FoodFinder2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> vowelsQueue.offer(e.charAt(0)));

        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> consonantsStack.push(e.charAt(0)));


        while (!consonantsStack.isEmpty()) {

            char currentVowel = vowelsQueue.poll();
            char currentConsonant = consonantsStack.pop();

            for (int index = 0; index < words.length; index++) {
                String word = words[index];
                int indexVowel = word.indexOf(currentVowel);
                int indexConsonant = word.indexOf(currentConsonant);

                if(indexVowel >= 0) {
                    foundWords[index] = foundWords[index].substring(0, indexVowel) + currentVowel + foundWords[index].substring(indexVowel +1);
                }
                if(indexConsonant >= 0) {
                    foundWords[index] = foundWords[index].substring(0, indexConsonant) + currentConsonant + foundWords[index].substring(indexConsonant + 1);
                }
            }
            vowelsQueue.offer(currentVowel);
        }
        List<String> totalWords = Arrays.stream(foundWords)
                .filter(el -> !el.contains("*"))
                .collect(Collectors.toList());

        System.out.printf("Words found: %d%n", totalWords.size());
        totalWords.forEach(el -> System.out.println(el));
    }
}
