package bitwiseOperation;

import java.util.Scanner;

public class P02BitAtPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int p = 1;
        int bit = (n >> p) & 1;

        System.out.println(bit);
    }
}
