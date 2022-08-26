package conditionStatementsExercise;

import java.util.Scanner;

public class ToyShop_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double holidayPrice = Double.parseDouble(scanner.nextLine());
        int puzzlesQty = Integer.parseInt(scanner.nextLine());
        int dollsQty = Integer.parseInt(scanner.nextLine());
        int bearsQty = Integer.parseInt(scanner.nextLine());
        int minionsQty = Integer.parseInt(scanner.nextLine());
        int trucksQty = Integer.parseInt(scanner.nextLine());

        double puzzlePrice = puzzlesQty * 2.60;
        double dollPrice = dollsQty * 3;
        double bearPrice = bearsQty * 4.10;
        double minionPrice = minionsQty * 8.20;
        double truckPrice = trucksQty * 2;

        int allToysQty = puzzlesQty + dollsQty + bearsQty + minionsQty + trucksQty;

        double allToysPrice = puzzlePrice + dollPrice + bearPrice + minionPrice + truckPrice;

        if (allToysQty >= 50) {
            allToysPrice = allToysPrice - (allToysPrice * 0.25);
        }
        double profit = allToysPrice - (allToysPrice * 0.10);

        if(profit >= holidayPrice){
            System.out.printf("Yes! %.2f lv left.", profit - holidayPrice);}
        else {
            System.out.printf("Not enough money! %.2f lv needed.", holidayPrice - profit);
            }
        }

    }
