package programming05FundamentalsFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String digitRegex = "\\d";
        String regex = "(?<emoji>([:]{2})[A-Z][a-z]{2,}([:]{2})|([*]{2})[A-Z][a-z]{2,}([*]{2}))";


        Pattern digits = Pattern.compile(digitRegex);
        Pattern patternEmoji = Pattern.compile(regex);

        String input = scanner.nextLine();


        long coolThreshold = 1;
        long sum = 0;


        Matcher digitMatcher = digits.matcher(input);
        Matcher regexMatcher = patternEmoji.matcher(input);
        List<String> allEmojiList = new ArrayList<>();
        List<String> coolEmojisList = new ArrayList<>();

        while (digitMatcher.find()) {
            int digit = Integer.parseInt(digitMatcher.group(0));
            coolThreshold = coolThreshold * digit;

        }

        while (regexMatcher.find()) {

            String name = regexMatcher.group("emoji");

            int currentSum = 0;
            for (int i = 2; i < name.length() - 2 ; i++) {
                char symbol = name.charAt(i);
                currentSum += symbol;

            }
            allEmojiList.add(name);
            if(currentSum > coolThreshold ) {
                coolEmojisList.add(name);

            }

        }
        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", allEmojiList.size());
        for (String emoji : coolEmojisList) {
            System.out.println(emoji);
        }
    }
}
