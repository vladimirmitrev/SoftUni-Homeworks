package exam15And16June2019;

import java.util.Scanner;

public class P05_Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double pointsAcademy = Double.parseDouble(scanner.nextLine());
        int judgeCount = Integer.parseInt(scanner.nextLine());

        boolean gotNominee = false;

        for (int i = 1; i <= judgeCount ; i++) {
            String judgeName = scanner.nextLine();
            double judgePoints = Double.parseDouble(scanner.nextLine());

            pointsAcademy = pointsAcademy + (judgeName.length() * judgePoints / 2);

            if (pointsAcademy > 1250.5) {
                gotNominee = true;
                break;
            }

        }
        if (gotNominee) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, pointsAcademy );
        } else {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - pointsAcademy);
        }
    }
}
