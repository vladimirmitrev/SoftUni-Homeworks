package firsStepsInCodingExersise;

import java.util.Scanner;

public class Repainting_06 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int nylonMeters = Integer.parseInt(scanner.nextLine());
        int paintLiters = Integer.parseInt(scanner.nextLine());
        int paintThinnerLiters = Integer.parseInt(scanner.nextLine());
        int hoursWork = Integer.parseInt(scanner.nextLine());

        double nylonPrice = (nylonMeters + 2) * 1.50;
        double paintPrice = (paintLiters * 1.1) * 14.50;
        double paintThinnerPrice = paintThinnerLiters * 5.00;
        double bagsPrice = 0.40;
        double sumForMaterials = nylonPrice + paintPrice + paintThinnerPrice + bagsPrice;
        double priceForLabor = (sumForMaterials * 0.3) * hoursWork;
        double totalPrice = sumForMaterials + priceForLabor;

        System.out.printf("%.2f", totalPrice);

    }

}
