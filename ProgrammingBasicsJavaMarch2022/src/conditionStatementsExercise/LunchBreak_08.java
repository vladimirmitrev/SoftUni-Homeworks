package conditionStatementsExercise;

import java.util.Scanner;

public class LunchBreak_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String serialName = scanner.nextLine();
        int serialMinutes = Integer.parseInt(scanner.nextLine());
        int breakMinutes = Integer.parseInt(scanner.nextLine());

        double lunchMinutes = breakMinutes / 8.0;
        double relaxMinutes = breakMinutes / 4.0;
        double remainingMinutes = breakMinutes - lunchMinutes - relaxMinutes;

        double difference = Math.abs(remainingMinutes - serialMinutes);

        if (remainingMinutes >= serialMinutes) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",
                    serialName, Math.ceil(difference));
        }   else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",
                    serialName, Math.ceil(difference));
        }
    }
}
