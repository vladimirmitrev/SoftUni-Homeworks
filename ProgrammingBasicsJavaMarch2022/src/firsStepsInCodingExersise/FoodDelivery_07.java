package firsStepsInCodingExersise;

import java.util.Scanner;

public class FoodDelivery_07 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int chickenMenu = Integer.parseInt(scanner.nextLine());

        int fishMenu = Integer.parseInt(scanner.nextLine());

        int vegetarian = Integer.parseInt(scanner.nextLine());


        double chickenPrice = chickenMenu * 10.35;

        double fishPrice = fishMenu * 12.40;

        double vegetarianPrice = vegetarian * 8.15;

        double allMenusPrice = chickenPrice + fishPrice + vegetarianPrice;

        double desertPrice = allMenusPrice * 0.2;

        double totalPrice = allMenusPrice + desertPrice + 2.50;

        System.out.printf("%.2f", totalPrice);


    }
}
