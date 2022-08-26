package moreExercisesConditionalStatements;

import java.util.Scanner;

public class P02_SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int holidayDays = Integer.parseInt(scanner.nextLine());

        int tomMinPerYear = 30000;
        int workingDayMin = 63;
        int holidayDayMin = 127;
        int dayWorking = 365 - holidayDays;
        int totalMinPerYear = (dayWorking * 63) + (holidayDays * 127);
        int hoursLeft = tomMinPerYear - totalMinPerYear;
        int totalHours = hoursLeft / 60;
        int totalMinutes = hoursLeft % 60;
        if (tomMinPerYear >= totalMinPerYear) {
            System.out.printf("Tom sleeps well%n");
            System.out.printf("%d hours and %d minutes less for play", totalHours, totalMinutes);
        } else {
            System.out.printf("Tom will run away%n");
            System.out.printf("%d hours and %d minutes more for play", Math.abs(totalHours), Math.abs(totalMinutes));
        }
    }
}
