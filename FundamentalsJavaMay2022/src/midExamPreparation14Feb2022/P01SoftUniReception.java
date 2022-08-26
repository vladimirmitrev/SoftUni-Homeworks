package midExamPreparation14Feb2022;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstWorker = Integer.parseInt(scanner.nextLine());
        int secondWorker = Integer.parseInt(scanner.nextLine());
        int thirdWorker = Integer.parseInt(scanner.nextLine());

        int allStudents = Integer.parseInt(scanner.nextLine());

        int studentsPerHour = firstWorker + secondWorker + thirdWorker;

        int hoursNeeded = 0;
        while (allStudents > 0) {
            hoursNeeded++;
            if (hoursNeeded % 4 != 0){
                allStudents -= studentsPerHour;
            }
        }

        System.out.printf("Time needed: %dh.", hoursNeeded);
    }
}
