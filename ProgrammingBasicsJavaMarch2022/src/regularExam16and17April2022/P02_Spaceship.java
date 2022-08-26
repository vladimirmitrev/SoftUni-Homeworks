package regularExam16and17April2022;

import java.util.Scanner;

public class P02_Spaceship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double shipWidth = Double.parseDouble(scanner.nextLine());
        double shipLength = Double.parseDouble(scanner.nextLine());
        double shipHeight = Double.parseDouble(scanner.nextLine());
        double peopleAverageHeight = Double.parseDouble(scanner.nextLine());

        double shipTotalVolume = shipWidth * shipLength * shipHeight;
        double oneRoomVolume = (peopleAverageHeight + 0.40) * 2 * 2;
        double numberOfRooms = Math.floor(shipTotalVolume / oneRoomVolume);

        if (numberOfRooms < 3) {
            System.out.println("The spacecraft is too small.");
        }
        else if (numberOfRooms >= 3 && numberOfRooms <= 10)
            System.out.printf("The spacecraft holds %.0f astronauts.", numberOfRooms);
        else {
                System.out.println("The spacecraft is too big.");
        }
    }
}


