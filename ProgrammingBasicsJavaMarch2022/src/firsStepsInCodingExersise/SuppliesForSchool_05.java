package firsStepsInCodingExersise;

import java.util.Scanner;

public class SuppliesForSchool_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int litersSoap = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double pensPrice = pens * 5.80;

        double markersPrice = markers * 7.20;

        double soapPrice = litersSoap * 1.20;

        double priceForAll = pensPrice + markersPrice + soapPrice;

        double discountProcent = discount * 0.01;

        double totalPrice = priceForAll - (priceForAll * discountProcent);

        System.out.printf("%.2f", totalPrice);

    }

}
