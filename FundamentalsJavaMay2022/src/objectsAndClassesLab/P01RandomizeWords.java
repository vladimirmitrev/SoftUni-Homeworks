package objectsAndClassesLab;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> wordList = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .collect(Collectors.toList());

        while(!wordList.isEmpty()) {
            Random rnd = new Random();
            int randomIndex = rnd.nextInt(wordList.size());
            String word = wordList.get(randomIndex);

            System.out.println(word);
            wordList.remove(randomIndex);

        }
    }
}
