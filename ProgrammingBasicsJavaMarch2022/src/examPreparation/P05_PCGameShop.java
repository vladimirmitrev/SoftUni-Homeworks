package examPreparation;

import java.util.Scanner;

public class P05_PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int hearthstoneCount = 0;
        int forniteCount = 0;
        int overWatchCount = 0;
        int othersCount = 0;

        for (int i = 1; i <=n ; i++) {
            String input = scanner.nextLine();
            if (input.equals("Hearthstone")) {
                hearthstoneCount++;
            } else if (input.equals("Fornite")) {
                forniteCount++;
            } else if (input.equals("Overwatch")) {
                overWatchCount++;
            } else {
                othersCount++;
            }
        }
        System.out.printf("Hearthstone - %.2f%%%n", hearthstoneCount * 1.0 * 100 / n);
        System.out.printf("Fornite - %.2f%%%n", forniteCount * 1.0 * 100 / n);
        System.out.printf("Overwatch - %.2f%%%n", overWatchCount * 1.0 * 100 / n);
        System.out.printf("Others - %.2f%%%n", othersCount * 1.0 * 100 / n);
    }
}
