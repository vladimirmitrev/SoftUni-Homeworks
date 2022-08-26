package firstStepsInCodingLab;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int packetsDogs = Integer.parseInt(scanner.nextLine());
        int packetsCats = Integer.parseInt(scanner.nextLine());

        double priceDogs = packetsDogs * 2.5;
        double priceCats = packetsCats * 4;

        double totalPrice = priceDogs + priceCats;

        System.out.printf("%.1f lv.", totalPrice);
    }
}
