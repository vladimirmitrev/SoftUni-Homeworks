package advancedConditionStatementsLab;

import java.util.Scanner;

public class CinemaTicket_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayOfWeek = scanner.next();

        int price = 0;

        if (dayOfWeek.equals("Monday") || (dayOfWeek.equals("Tuesday") || (dayOfWeek.equals("Friday"))))  {
            price = 12;
        } else if (dayOfWeek.equals("Wednesday") || (dayOfWeek.equals("Thursday"))) {
            price = 14;
        } else if (dayOfWeek.equals("Saturday") || (dayOfWeek.equals("Sunday"))) {
            price = 16;
        }
        System.out.println(price);

    }
}
