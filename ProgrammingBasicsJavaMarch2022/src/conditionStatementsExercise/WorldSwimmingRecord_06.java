package conditionStatementsExercise;

import java.util.Scanner;

public class WorldSwimmingRecord_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double worldRecord = Double.parseDouble(scanner.nextLine());
        double totalDistance = Double.parseDouble(scanner.nextLine());
        double timeForOneMeter = Double.parseDouble(scanner.nextLine());

        double timeDistance = totalDistance * timeForOneMeter;

        double timeSlower = Math.floor(totalDistance / 15);
        double totalTimeSlower = timeSlower * 12.5;
        double totalTimeAll = timeDistance + totalTimeSlower;

        if (totalTimeAll < worldRecord) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTimeAll);
            }else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(worldRecord - totalTimeAll));
        }


    }
}
