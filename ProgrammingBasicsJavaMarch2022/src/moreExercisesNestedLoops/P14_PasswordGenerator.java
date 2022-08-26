package moreExercisesNestedLoops;

import java.util.Scanner;

public class P14_PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());

        for (int dig1 = 1; dig1 <= n ; dig1++) {
            for (int dig2 = 1; dig2 <= n ; dig2++) {
                for (char dig3 = 'a'; dig3 <= l + 96; dig3++) {
                    for (char dig4 = 'a'; dig4 <= l + 96; dig4++) {
                        for (int  dig5 = 1;  dig5 <= n ; dig5++) {
                            if (dig5 > dig1 && dig5 > dig2) {
                                System.out.printf("%d%d%s%s%d ", dig1, dig2, dig3, dig4, dig5);
                            }
                        }
                      }
                    }
                }
            }
        }
    }

