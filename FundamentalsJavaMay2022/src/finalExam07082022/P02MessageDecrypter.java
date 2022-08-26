package finalExam07082022;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^(\\$|%)([A-Z][a-z]{2,})\\1: \\[(\\d+)\\]\\|\\[(\\d+)\\]\\|\\[(\\d+)\\]\\|$";

        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);

            if(matcher.find()) {
                String tag = matcher.group(2);
                int firstNum = Integer.parseInt(matcher.group(3));
                int secondNum = Integer.parseInt(matcher.group(4));
                int thirdNum = Integer.parseInt(matcher.group(5));
                char first = (char) firstNum;
                char second = (char) secondNum;
                char third = (char) thirdNum;

                System.out.printf("%s: %c%c%c%n", tag, first, second, third);


            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
