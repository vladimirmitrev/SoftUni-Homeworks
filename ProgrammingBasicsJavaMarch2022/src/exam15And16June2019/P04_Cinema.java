package exam15And16June2019;

import java.util.Scanner;

public class P04_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        double totalPrice = 0;

        int peopleCount = 0;


        while (!input.equals("Movie time!")) {
            int currentPeople = Integer.parseInt(input);
            capacity -= currentPeople;

            if (capacity < 0) {
                break;
            }
            if (currentPeople % 3 == 0) {
                totalPrice = totalPrice + (currentPeople * 5) - 5;
            } else {
                totalPrice = totalPrice + (currentPeople * 5);
            }

            input = scanner.nextLine();
        }
        if (capacity > 0 || capacity == 0) {
            System.out.printf("There are %d seats left in the cinema.%n", capacity);
        } else {
            System.out.printf("The cinema is full.%n");
        }
        System.out.printf("Cinema income - %.0f lv.", totalPrice);
    }
}
