package moreExercisesNestedLoops;

import java.util.Scanner;

public class P13_PrimePairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start1 = Integer.parseInt(scanner.nextLine());
        int start2 = Integer.parseInt(scanner.nextLine());
        int diff1 = Integer.parseInt(scanner.nextLine());
        int diff2 = Integer.parseInt(scanner.nextLine());
        int end1 = start1 + diff1;
        int end2 = start2 + diff2;
        
        int pair1Counter = 0;
        int pair2Counter = 0;
        

        for (int pair1 = start1; pair1 <= end1 ; pair1++) {
            for (int primeChecker1 = 1; primeChecker1 <= pair1 ; primeChecker1++) {
                if (pair1 % primeChecker1 == 0) {
                    pair1Counter++;
                }
            }
            if (pair1Counter == 2) {
                for (int pair2 = start2; pair2 <= end2 ; pair2++) {
                    for (int primeChecker2 = 1; primeChecker2 <= pair2; primeChecker2++) {
                        if (pair2 % primeChecker2 == 0) {
                            pair2Counter++;
                        }
                    }
                    if (pair2Counter == 2) {
                        System.out.printf("%d%d%n", pair1, pair2);
                    } else {
                        pair2Counter = 0;
                    }
                }
            } else {
                pair1Counter = 0;
            }

        }
    }
}
