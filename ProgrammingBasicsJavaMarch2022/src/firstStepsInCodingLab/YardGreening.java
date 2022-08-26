package firstStepsInCodingLab;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sqMeters = Double.parseDouble(scanner.nextLine());

        double totalPrice = sqMeters * 7.61;

        double discount = totalPrice * 0.18;

//        The final price is: 3432.11 lv.
//        The discount is: 753.39 lv.

        double finalPrice = totalPrice - discount;

        System.out.printf("The final price is: %f lv.%n", finalPrice);
        System.out.printf("The discount is: %f lv.", discount);
    }
}
