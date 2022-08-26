package moreExeriseForLoop;

import java.util.Scanner;

public class P02_Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int doctors = 7;
        int treatPatients = 0;
        int unTreatPatients = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (unTreatPatients > treatPatients) {
                    doctors++;
                }
            }
            int currentPatients = Integer.parseInt(scanner.nextLine());
            if (doctors < currentPatients) {
                treatPatients += doctors;
                unTreatPatients += currentPatients - doctors;
            } else {
                treatPatients += currentPatients;
            }
        }
        System.out.printf("Treated patients: %d.%n", treatPatients);
        System.out.printf("Untreated patients: %d.", unTreatPatients);
    }
}
