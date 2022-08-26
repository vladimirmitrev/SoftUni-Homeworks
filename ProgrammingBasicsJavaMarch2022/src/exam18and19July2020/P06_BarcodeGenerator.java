package exam18and19July2020;

import java.util.Scanner;

public class P06_BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        int f1 = (start / 1000) % 10;
        int f2 = (start / 100) % 10;
        int f3 = (start / 10) % 10;
        int f4 = start % 10;

        int h1 = (end / 1000) % 10;
        int h2 = (end / 100) % 10;
        int h3 = (end / 10) % 10;
        int h4 = end % 10;

        for (int i = f1; i <= h1 ; i++) {
            for (int j = f2; j <= h2 ; j++) {
                for (int k = f3; k <= h3 ; k++) {
                    for (int l = f4; l <= h4 ; l++) {

                        if ( i % 2 != 0 && j % 2 != 0 && l % 2 != 0 && k % 2 != 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }

                    }

                }

            }
            
        }



    }
}
