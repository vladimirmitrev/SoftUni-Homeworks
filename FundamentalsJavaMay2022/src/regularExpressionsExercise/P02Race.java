package regularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();

        List<String> racersNames = Arrays.stream(names.split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        Pattern letterPattern = Pattern.compile("[A-Za-z]+");

        Pattern digitPattern = Pattern.compile("[0-9]");

        Map<String, Integer> distances = new LinkedHashMap<>();
        racersNames.forEach(name -> distances.put(name, 0));

        while (!input.equals("end of race")) {
            int totalDistance = 0;
            StringBuilder nameBuilder = new StringBuilder();

            Matcher letterMatcher = letterPattern.matcher(input);
            while (letterMatcher.find()) {
                nameBuilder.append(letterMatcher.group());
            }

            Matcher digitMatcher = digitPattern.matcher(input);
            while(digitMatcher.find()) {
                totalDistance += Integer.parseInt(digitMatcher.group());
            }

            String racerName = nameBuilder.toString();
            if(distances.containsKey(racerName)) {
                int currentDistance = distances.get(racerName);
                distances.put(racerName, currentDistance + totalDistance);
            }

            input = scanner.nextLine();
        }
       List<String> firstThree = distances.entrySet().stream()
               .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
               .limit(3)
               .map(entry -> entry.getKey())
               .collect(Collectors.toList());

        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));
    }
}
