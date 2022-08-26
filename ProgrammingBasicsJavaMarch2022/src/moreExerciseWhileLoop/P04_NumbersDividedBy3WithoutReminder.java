package moreExerciseWhileLoop;

import java.util.Scanner;

public class P04_NumbersDividedBy3WithoutReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <=100 ; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}
