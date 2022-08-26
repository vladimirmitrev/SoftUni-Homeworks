package selfTesting;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double area = Double.parseDouble(scanner.nextLine());
        double priceForM = area * 7.61;
        double discont = priceForM * 0.18;
        double totalPrice = priceForM - discont;

        System.out.printf("The final price is: %.2f lv.%n", totalPrice);
        System.out.printf("The discount is: %.2f lv.", discont);


    }
}
