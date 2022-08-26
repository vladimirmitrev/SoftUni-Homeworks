package programming01FundamentalsFinalExamRetake;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstraRetake33from100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(#|\\|)(?<item>[A-Za-z ]+)\\1(?<expirationDate>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>\\d+)\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        Map<String, List<String>> itemsMap = new LinkedHashMap<>();
        int totalCalories = 0;

        while (matcher.find()) {
            String item = matcher.group("item");
            String expirationDate = matcher.group("expirationDate");
            String calories = matcher.group("calories");

            int caloriesInt = Integer.parseInt(calories);

            totalCalories += caloriesInt;

            if (itemsMap.containsKey(item)) {
                int currentCalories = Integer.parseInt(itemsMap.get(item).get(1));
                int newCalories = currentCalories + caloriesInt;
                Integer newCal = new Integer(newCalories);
                String newCalStr = String.valueOf(newCal);

                itemsMap.get(item).set(1, newCalStr);
            } else {
                itemsMap.put(item, new ArrayList<>());
                itemsMap.get(item).add(0, expirationDate);
                itemsMap.get(item).add(1, calories);
            }

        }
        int totalDays = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", totalDays);

        itemsMap.forEach((key, value) -> System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n"
                , key, value.get(0), value.get(1)));
    }
}

