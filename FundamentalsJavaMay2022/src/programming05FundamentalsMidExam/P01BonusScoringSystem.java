package programming05FundamentalsMidExam;

import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudnets = Integer.parseInt(scanner.nextLine());
        int numberOfLectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int maxAttendance = 0;

        for (int i = 0; i < numberOfStudnets ; i++) {
                int attendance = Integer.parseInt(scanner.nextLine());

                double totalBonus = attendance * 1.0 / numberOfLectures * (5 + bonus);

                if (maxBonus < totalBonus) {
                    maxBonus = totalBonus;
                    maxAttendance = attendance;
                }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxAttendance);
    }
}
