package firsStepsInCodingExersise;

import java.util.Scanner;

public class BasketballEquipment_08 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int tax = Integer.parseInt(scanner.nextLine());

        double shoesPrice = tax - (tax * 0.40);

        double clothesPrice = shoesPrice - (shoesPrice * 0.20);

        double ballPrice = clothesPrice / 4;

        double accessories = ballPrice / 5;

        double totalPrice = tax + shoesPrice + clothesPrice + ballPrice + accessories;

        System.out.printf("%.2f", totalPrice);

    }
}
