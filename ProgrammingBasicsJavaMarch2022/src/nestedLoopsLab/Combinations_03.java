package nestedLoopsLab;

import java.util.Scanner;

public class Combinations_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    int sum = i + j + k;
                    if (sum == n) {
                        count++;
                    }
                }

            }
        }
        System.out.println(count);
    }
}
