package forLoolExercise;

import java.util.Scanner;

public class    TrekkingMania_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int musala = 0;
        int monblanc = 0;
        int kilimandjaro = 0;
        int k2 = 0;
        int everest = 0;
        int allPeople = 0;

        for (int i = 0; i < n ; i++) {
            int people = Integer.parseInt(scanner.nextLine());

            if (people <= 5) {
                musala = musala + people;
            } else if (people <=12) {
                monblanc = monblanc + people;
            } else if (people <= 25) {
                kilimandjaro = kilimandjaro + people;
            } else if (people <= 40) {
                k2 = k2 + people;
            } else {
                everest = everest + people;
            }
            allPeople += people;
        }
        System.out.printf("%.2f%%%n", musala * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n", monblanc * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n", kilimandjaro * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n", k2 * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n", everest * 1.0 / allPeople * 100);
    }
}
