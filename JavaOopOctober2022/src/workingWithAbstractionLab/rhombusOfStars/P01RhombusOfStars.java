package workingWithAbstractionLab.rhombusOfStars;

import java.util.Scanner;

public class P01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTop(n);

        printMiddle(n);

        printBottom(n);

    }

    private static void printBottom(int n) {
        for (int row = n - 1; row >= 1 ; row--) {
            printRow(n, row);
        }
    }

    private static void printMiddle(int n) {
        for (int star = 1; star <= n; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printTop(int n) {
        for (int row = 1; row <= n - 1 ; row++) {
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {

        for (int space = 1; space <= n - row ; space++) {
            System.out.print(" ");
        }
        printMiddle(row);
    }
}
