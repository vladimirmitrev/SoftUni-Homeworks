package programming05FundamentalsFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetectorRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();

        int coolThreshold = 1;

        String digitRegex = "\\d";
        String regex = "(?<emoji>[:]{2}[A-Z][a-z]{2,}[:]{2}|[*]{2}[A-Z][a-z]{2,}[*]{2})";


        Pattern patternDigits = Pattern.compile(digitRegex);
        Pattern patternLetters = Pattern.compile(regex);

        Matcher matcherDigits = patternDigits.matcher(inputText);
        Matcher matcherLetters = patternLetters.matcher(inputText);

        List<String> allEmojisList = new ArrayList<>();
        List<String> coolEmojisList = new ArrayList<>();

        while (matcherDigits.find()) {
            int digits = Integer.parseInt(matcherDigits.group(0));
            coolThreshold = coolThreshold * digits;
        }

        while (matcherLetters.find()) {
            String emoji = matcherLetters.group("emoji");
            allEmojisList.add(emoji);
            int emojiSum = 0;
            for (int i = 2; i < emoji.length() - 2 ; i++) {
                int emojiLetter = emoji.charAt(i);

                emojiSum += emojiLetter;
            }
            if(emojiSum >= coolThreshold) {
                coolEmojisList.add(emoji);
            }
        }
        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", allEmojisList.size());
        for (String emoji : coolEmojisList) {
            System.out.println(emoji);
        }
    }
}
