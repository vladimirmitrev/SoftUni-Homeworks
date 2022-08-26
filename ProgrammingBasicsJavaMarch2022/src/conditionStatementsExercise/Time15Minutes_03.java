package conditionStatementsExercise;

import java.util.Scanner;

public class Time15Minutes_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = hour * 60 + minutes + 15;

        hour = totalMinutes / 60;
        minutes = totalMinutes % 60;

        if (hour > 23) {
            hour = 0;
        }
        if (minutes < 10) {
            System.out.printf("%d:0%d", hour, minutes);
        } else {
            System.out.printf("%d:%d", hour, minutes);
        }

    }
}
