package whileLoopExercise;

import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vacationMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        double totalMoney = availableMoney;

        int spendDays = 0;
        int totalDays = 0;
        boolean cantSave = false;

        while (totalMoney < vacationMoney) {
            totalDays++;
            String command = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());

            switch (command) {
                case "save":
                    spendDays = 0;
                    totalMoney = totalMoney + money;
                    break;
                case "spend":
                    spendDays++;
                    totalMoney = totalMoney - money;
                    if (totalMoney < 0) {
                        totalMoney = 0;
                    }
                    break;
            }
            if (spendDays == 5) {
                cantSave = true;
                break;
            }
        }
        if (cantSave) {
            System.out.println("You can't save the money.");
            System.out.println(totalDays);
        } else {
            System.out.printf("You saved the money for %d days.", totalDays);
        }
    }
}
