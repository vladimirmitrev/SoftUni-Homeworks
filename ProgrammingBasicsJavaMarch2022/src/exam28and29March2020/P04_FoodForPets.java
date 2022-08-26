package exam28and29March2020;

import java.util.Scanner;

public class P04_FoodForPets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());
        double biscuitEaten = 0;
        double dogAte = 0;
        double catAte = 0;

        for (int i = 1; i <=n ; i++) {
            int dogEatPerDay = Integer.parseInt(scanner.nextLine());
            dogAte = dogAte + dogEatPerDay;
            int catEatPerDay = Integer.parseInt(scanner.nextLine());
            catAte = catAte + catEatPerDay;
            if (i % 3 == 0) {
                biscuitEaten = biscuitEaten + 0.10 * (dogEatPerDay + catEatPerDay);
            }
        }
        biscuitEaten = Math.round(biscuitEaten);
        double bothAte = dogAte + catAte;
        double percentFoodEaten = (dogAte + catAte) / totalFood * 100;


        System.out.printf("Total eaten biscuits: %.0fgr.%n", biscuitEaten);
        System.out.printf("%.2f%% of the food has been eaten.%n", percentFoodEaten);
        System.out.printf("%.2f%% eaten from the dog.%n", dogAte / bothAte * 100);
        System.out.printf("%.2f%% eaten from the cat.%n", catAte / bothAte * 100);

    }
}
