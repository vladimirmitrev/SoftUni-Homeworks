package moreExercisesNestedLoops;

import java.util.Scanner;

public class P06_WeddingSeats {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lastSector = scanner.nextLine();
        int rowsInSectorA = Integer.parseInt(scanner.nextLine());
        int seatsOddRow = Integer.parseInt(scanner.nextLine());

        int seatsCounter = 0;
        int factor = 0;

        for (char i = 'A'; i <= lastSector.charAt(0); i++, rowsInSectorA++) {

            for (int j = 1; j <= rowsInSectorA ; j++) {
                factor = (j % 2 == 0) ? 2 : 0;
                for (char k = 'a'; k < 'a' + seatsOddRow + factor; k++) {
                    System.out.printf("%c%d%c%n", i, j, k);
                    seatsCounter++;

                }
            }
        }
        System.out.printf("%d", seatsCounter);
    }
}
