package forLoolExercise;

import java.util.Scanner;

public class Oscars_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double startPoints = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            String pointsGiver = scanner.nextLine();
            double points = Double.parseDouble(scanner.nextLine());

            int length = pointsGiver.length();
            double calculatedPoints = length * points / 2;

            startPoints = startPoints + calculatedPoints;

            if (startPoints > 1250.5) {
                break;
            }
        }
        if (startPoints > 1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, startPoints);
        } else {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - startPoints);
        }
    }
}
