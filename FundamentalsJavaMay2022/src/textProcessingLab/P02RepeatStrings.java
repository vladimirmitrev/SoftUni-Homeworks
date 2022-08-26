package textProcessingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        List<String> repeatList = new ArrayList<>();
        for (int i = 0; i < words.length ; i++) {
            String currentWord = words[i];
            int length = currentWord.length();

            String repeatWord = repeatStr(currentWord, length);
            repeatList.add(repeatWord);

        }
        System.out.println(String.join("", repeatList));
    }
    public static String repeatStr(String s, int count) {
        String result = "";
        for (int i = 0; i < count ; i++) {
            result += s;
        }
        return result;
    }
}
