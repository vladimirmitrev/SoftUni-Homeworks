package programming01FundamentalsFinalExamRetake;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(#|\\|)(?<item>[A-Za-z ]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>\\d+)\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int sumOfCalories = 0;
        List<String> items = new LinkedList<>();

        while (matcher.find()) {
            String item = matcher.group("item");
            String date = matcher.group("date");
            int caloriesInt = Integer.parseInt(matcher.group("calories"));

            sumOfCalories += caloriesInt;

            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d%n", item, date, caloriesInt));


        }
        int totalDaysFood = sumOfCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", totalDaysFood);

        for (String item : items) {
            System.out.print(item);
        }

    }
}
