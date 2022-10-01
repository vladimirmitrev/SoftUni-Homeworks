package setsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> carNumbers = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String direction = tokens[0];
            String numbers = tokens[1];

            if(direction.equals("IN")) {
                carNumbers.add(numbers);
            } else {
                carNumbers.remove(numbers);
            }

            input = scanner.nextLine();
        }
        if(carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), carNumbers));
        }

    }
}
