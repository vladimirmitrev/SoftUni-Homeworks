package moreExeriseForLoop;

import java.util.Scanner;

public class P09_Clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int h = 0; h <= 23 ; h++) {
            for (int m = 0; m <= 59 ; m++) {
                System.out.printf("%d : %d%n", h, m);
            }
        }
    }
}
