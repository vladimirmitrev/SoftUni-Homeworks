package textProcessingMoreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String text = scanner.nextLine();
            String nameRegex = "@(?<name>[A-Za-z]+)\\|";
            String ageRegex = "#(?<age>[0-9]+)\\*";

            Pattern patternName = Pattern.compile(nameRegex);
            Matcher matcherName = patternName.matcher(text);
            Pattern patternAge = Pattern.compile(ageRegex);
            Matcher matcherAge = patternAge.matcher(text);

            while (matcherName.find() && matcherAge.find()) {
                String name = matcherName.group("name");
                String age = matcherAge.group("age");

                System.out.printf("%s is %s years old.%n", name, age);
            }
        }

    }
}
