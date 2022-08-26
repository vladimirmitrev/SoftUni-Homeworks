package basicSyntax;

import java.util.Scanner;

public class P04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputHour = Integer.parseInt(scanner.nextLine());
        int inputMin = Integer.parseInt(scanner.nextLine());

        int totalMin = inputHour * 60 + inputMin + 30;

        int hour = totalMin / 60;
        int min = totalMin % 60;

        if (hour > 23) {
            hour = 0;
        }
        System.out.printf("%d:%02d", hour, min);

    }
}
