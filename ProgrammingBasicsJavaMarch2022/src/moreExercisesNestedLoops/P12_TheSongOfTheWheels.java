package moreExercisesNestedLoops;

import java.util.Scanner;

public class P12_TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());
        int passCounter = 0;
        String password = "No!";
        boolean rightPasswordNot = true;

        for (int a = 1; a <=9 ; a++) {
            for (int b = 1; b <=9 ; b++) {
                for (int c = 1; c <=9 ; c++) {
                    for (int d = 1; d <=9 ; d++) {
                        if (a < b && c > d) {
                            if (a * b + c * d == m) {
                                System.out.printf("%d%d%d%d ", a, b, c, d);
                                passCounter++;
                            }
                            if (passCounter == 4 && rightPasswordNot) {
                                password = "Password: " + a + b + c + d;
                                rightPasswordNot = false;
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("%n%s", password);
        }
    }

