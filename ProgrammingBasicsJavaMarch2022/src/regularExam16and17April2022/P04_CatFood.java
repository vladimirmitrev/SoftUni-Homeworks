package regularExam16and17April2022;

import java.util.Scanner;

public class P04_CatFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int catsCount = Integer.parseInt(scanner.nextLine());

        int groupOne = 0;
        int groupTwo = 0;
        int groupThree = 0;
        double totalFood = 0;

        for (int i = 1; i <= catsCount ; i++) {
            int foodPerCat = Integer.parseInt(scanner.nextLine());
            if (foodPerCat >= 100 && foodPerCat < 200){
                groupOne++;
            } else if (foodPerCat >= 200 && foodPerCat < 300) {
                groupTwo++;
            } else if (foodPerCat >= 300 && foodPerCat < 400) {
                groupThree++;
            }
            totalFood += foodPerCat;
        }
        double totalFoodKg = totalFood  / 1000;
        double totalPrice = totalFoodKg * 12.45;

        System.out.printf("Group 1: %d cats.%n", groupOne);
        System.out.printf("Group 2: %d cats.%n", groupTwo);
        System.out.printf("Group 3: %d cats.%n", groupThree);
        System.out.printf("Price for food per day: %.2f lv.", totalPrice);

    }
}
