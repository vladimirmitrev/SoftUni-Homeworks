package programming02FundamentalsFinalExam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapperRetake2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> destinationsList = new ArrayList<>();
        int travelPoints = 0;
        while (matcher.find()) {
            String destination = matcher.group("destination");

            travelPoints += destination.length();
            destinationsList.add(destination);
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinationsList));
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
