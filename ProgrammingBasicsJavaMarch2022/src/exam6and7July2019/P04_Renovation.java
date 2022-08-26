package exam6and7July2019;

import java.util.Scanner;

public class P04_Renovation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wallHeight = Integer.parseInt(scanner.nextLine());
        int wallLength  = Integer.parseInt(scanner.nextLine());
        int percentNo = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int areaToPaint = wallHeight * wallLength * 4;
        int totalToPaint = (int)Math.ceil(areaToPaint - (areaToPaint * 1.0 * percentNo / 100));

        while (!command.equals("Tired!")) {
            int paintLitters = Integer.parseInt(command);
            totalToPaint = totalToPaint - paintLitters;
            if (totalToPaint <= 0) {
                break;
            }
            command = scanner.nextLine();
        }

        if (totalToPaint > 0) {
            System.out.printf("%d quadratic m left.", totalToPaint);
        } else if (totalToPaint == 0) {
            System.out.println("All walls are painted! Great job, Pesho!");
        } else {
            System.out.printf("All walls are painted and you have %d l" +
                    " paint left!", Math.abs(totalToPaint));
        }
    }
}
