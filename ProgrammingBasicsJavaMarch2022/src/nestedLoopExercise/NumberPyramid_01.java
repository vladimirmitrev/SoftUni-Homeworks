package nestedLoopExercise;

import java.util.Scanner;

public class NumberPyramid_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int number = 1;
        boolean isBigger = false;

        for (int rows = 1; rows <= n ; rows++) {
            for (int colums = 1; colums <= rows; colums++) {
                if (number > n) {
                    isBigger = true;
                    break;
                }
                System.out.print(number + " ");
                number++;
            }
            if (isBigger) {
                break;
            }
            System.out.println();
        }
    }
}
