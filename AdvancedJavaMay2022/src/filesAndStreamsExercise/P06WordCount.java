package filesAndStreamsExercise;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P06WordCount {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new FileReader("src/filesAndStreamsExercise/resources/words.txt"));
            Scanner readText = new Scanner(new FileReader("src/filesAndStreamsExercise/resources/text.txt"));
            PrintWriter printWriter = new PrintWriter("src/filesAndStreamsExercise/resources/results.txt"))
            {
            LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();
            Arrays.stream(scanner.nextLine().split(" ")).forEach(word -> wordMap.put(word, 0));

            while(readText.hasNext()) {
                String textInput = readText.next();
                if(wordMap.containsKey(textInput)) {
                    int occurrence = wordMap.get(textInput);
                    occurrence++;
                    wordMap.put(textInput, occurrence);
                }
            }
            wordMap.entrySet().forEach(word -> printWriter.printf("%s - %d%n", word.getKey(), word.getValue()));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
