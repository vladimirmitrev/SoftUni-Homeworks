package advancedConditionStatementExercise;

import java.util.Scanner;

public class SkiTrip_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String posOrNeg = scanner.nextLine();

        double roomPrice = 0;

        switch (roomType) {
            case "room for one person":
                roomPrice = (days - 1) * 18;
                break;

            case "apartment":
                roomPrice = (days - 1) * 25;
                if (days < 10) {
                    roomPrice = roomPrice * 0.7;
                } else if (days >= 10 && days <= 15) {
                    roomPrice = roomPrice * 0.65;
                } else if (days > 15) {
                    roomPrice = roomPrice * 0.5;
                }
                break;
            case "president apartment":
                roomPrice = (days - 1) * 35;
                if (days < 10) {
                    roomPrice = roomPrice * 0.9;
                } else if (days >= 10 && days <=15) {
                    roomPrice = roomPrice * 0.85;
                } else if (days > 15) {
                    roomPrice = roomPrice * 0.8;
                }
                    break;
                }
                if (posOrNeg.equals("positive")) {
                    roomPrice = roomPrice * 1.25;
                } else if (posOrNeg.equals("negative")) {
                    roomPrice = roomPrice * 0.9;
        }
        System.out.printf("%.2f", roomPrice);

    }
}
