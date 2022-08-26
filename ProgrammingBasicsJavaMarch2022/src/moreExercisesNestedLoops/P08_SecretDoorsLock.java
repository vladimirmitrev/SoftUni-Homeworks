package moreExercisesNestedLoops;

import java.util.Scanner;

public class P08_SecretDoorsLock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n1; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= n2; j++) {
                    if (j == 2 || j == 3 || j == 5 || j == 7) {
                        for (int k = 1; k <= n3; k++) {
                            if (k % 2 == 0) {
                                System.out.printf("%d %d %d%n", i, j, k);

                            }
                        }
                    }
                }
            }
        }
    }
}
