package programming01FundamentalsFinalExamRetake;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstraRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(#|\\|)(?<item>[A-Za-z ]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>\\d+)\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int totalCalories = 0;
        List<String> itemsList = new ArrayList<>();


        while (matcher.find()) {
            String item = matcher.group("item");
            String date = matcher.group("date");
            String calories = matcher.group("calories");
            int caloriesInt = Integer.parseInt(calories);
            totalCalories += caloriesInt;

            itemsList.add(String.format("Item: %s, Best before: %s, Nutrition: %s%n", item, date, calories));

        }
        int totalDays = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", totalDays);

        for (String item : itemsList) {
            System.out.print(item);
        }

    }
}
