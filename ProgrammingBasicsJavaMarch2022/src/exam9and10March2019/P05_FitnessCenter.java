package exam9and10March2019;

import java.util.Scanner;

public class P05_FitnessCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         int n = Integer.parseInt(scanner.nextLine());

         int backCount = 0;
         int chestCount = 0;
         int legsCount = 0;
         int absCount = 0;
         int shakeCount = 0;
         int barCount = 0;
         int workoutCount = 0;
         int shoppingCount = 0;


        for (int i = 1; i <= n ; i++) {
            String type = scanner.nextLine();

            switch (type) {
                case "Back":
                    backCount++;
                    workoutCount++;
                    break;
                case "Chest":
                    chestCount++;
                    workoutCount++;
                    break;
                case "Legs":
                    legsCount++;
                    workoutCount++;
                    break;
                case "Abs":
                    absCount++;
                    workoutCount++;
                    break;
                case "Protein shake":
                    shakeCount++;
                    shoppingCount++;
                    break;
                case "Protein bar":
                    barCount++;
                    shoppingCount++;
                    break;
            }
        }
        double percentWork = workoutCount * 1.0 / n * 100;
        double percentProtein = shoppingCount * 1.0 / n * 100;

        System.out.printf("%d - back%n", backCount);
        System.out.printf("%d - chest%n", chestCount);
        System.out.printf("%d - legs%n", legsCount);
        System.out.printf("%d - abs%n", absCount);
        System.out.printf("%d - protein shake%n", shakeCount);
        System.out.printf("%d - protein bar%n", barCount);
        System.out.printf("%.2f%% - work out%n", percentWork);
        System.out.printf("%.2f%% - protein", percentProtein);
    }
}
