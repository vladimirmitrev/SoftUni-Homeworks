package regularExam16and17April2022;

import java.util.Scanner;

public class P05_ChristmasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        int kidsCount = 0;
        int adultCount = 0;
        double toyPrice = 5;
        double sweaterPrice = 15;

        while (!command.equals("Christmas")) {
            int years = Integer.parseInt(command);

            if (years <= 16) {
                kidsCount++;
            }if (years > 16){
                adultCount++;
            }
            command = scanner.nextLine();
        }
        double totalToyPrice = toyPrice * kidsCount;
        double totalSweaterPrice = sweaterPrice * adultCount;

        System.out.printf("Number of adults: %d%n", adultCount);
        System.out.printf("Number of kids: %d%n", kidsCount);
        System.out.printf("Money for toys: %.0f%n", totalToyPrice);
        System.out.printf("Money for sweaters: %.0f", totalSweaterPrice);

    }
}
