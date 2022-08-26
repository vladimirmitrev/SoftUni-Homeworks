package programming03FundamentalsFinalExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWordsRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "([@|#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> mirrorWordsList = new ArrayList<>();
        int countValidPairs = 0;

        while (matcher.find()) {
            String firstWord = matcher.group("wordOne");
            String secondWord = matcher.group("wordTwo");
            countValidPairs++;
            StringBuilder secondWordReverse = new StringBuilder(secondWord).reverse();
            String secondWordReverseString = secondWordReverse.toString();

            if(secondWordReverseString.equals(firstWord)) {
                String mirrorWord = firstWord + " <=> " + secondWord;
                mirrorWordsList.add(mirrorWord);
            }
        }
        if(countValidPairs > 0) {
            System.out.printf("%d word pairs found!%n", countValidPairs);
        } else {
            System.out.println("No word pairs found!");
        }
        if(mirrorWordsList.size() > 0) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWordsList));
        } else {
            System.out.println("No mirror words!");
        }
    }
}
