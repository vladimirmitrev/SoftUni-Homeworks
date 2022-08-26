package finalExamPrep01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(@|#)(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int countPairs = 0;
        List<String> mirrorWords = new ArrayList<>();

        while (matcher.find()) {
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            countPairs++;
            StringBuilder reversedBuilder = new StringBuilder(secondWord).reverse();
            String secondWordReverse = reversedBuilder.toString();
            if(secondWordReverse.equals(firstWord)) {
                mirrorWords.add(firstWord + " <=> " + secondWord);
            }
        }

        if (countPairs > 0) {
            System.out.println(countPairs + " word pairs found!");
        } else {
            System.out.println("No word pairs found!");
        }
        if (mirrorWords.size() > 0) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        } else {
            System.out.println("No mirror words!");
        }

    }
}
