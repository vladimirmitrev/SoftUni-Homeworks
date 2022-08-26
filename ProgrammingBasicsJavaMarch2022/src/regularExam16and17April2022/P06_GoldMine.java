package regularExam16and17April2022;

import java.util.Scanner;

public class P06_GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int locations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < locations ; i++) {
            double averagePerDay = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            double goldSum = 0;
            for (int j = 0; j < days ; j++) {
                double goldPerDay = Double.parseDouble(scanner.nextLine());
                goldSum += goldPerDay;
            }
            double average = goldSum / days;
            if (average >= averagePerDay) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", average);
            } else {
                System.out.printf("You need %.2f gold.%n", averagePerDay - average);
            }
        }
    }
}
