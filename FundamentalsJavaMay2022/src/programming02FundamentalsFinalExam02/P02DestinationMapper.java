package programming02FundamentalsFinalExam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(=|\\/)(?<destination>[A-Z]{1}[A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int totalPoints = 0;
        List<String> destinationsList = new ArrayList<>();
        while (matcher.find()) {
            String destination = matcher.group("destination");
            destinationsList.add(destination);
            totalPoints += destination.length();

        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinationsList));
        System.out.printf("Travel Points: %d", totalPoints);
    }
}
