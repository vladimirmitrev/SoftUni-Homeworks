package programming04FundamentalsMidExam;

import java.util.Scanner;

public class P01GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalFood = Double.parseDouble(scanner.nextLine()) * 1000;
        double totalHay = Double.parseDouble(scanner.nextLine()) * 1000;
        double totalCover = Double.parseDouble(scanner.nextLine()) * 1000;
        double pigWeight = Double.parseDouble(scanner.nextLine()) * 1000;

        int totalDays = 1;

        while (totalDays <= 30) {

            totalFood -= 300;
            if (totalDays % 2 == 0) {
                double hayFood = totalFood * 0.05;
                totalHay -= hayFood;
            }
            if (totalDays % 3 == 0) {
                double cover = pigWeight / 3;
                totalCover -= cover;
            }
            totalDays++;
        }
        double foodKg = totalFood / 1000;
        double hayKg = totalHay / 1000;
        double coverKg = totalCover / 1000;

        if (foodKg >= 0 && hayKg  >= 0 && coverKg >= 0) {
            System.out.printf("Everything is fine! Puppy is happy! " +
                    "Food: %.2f, Hay: %.2f, Cover: %.2f.", foodKg, hayKg, coverKg);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}