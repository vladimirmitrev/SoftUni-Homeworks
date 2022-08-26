package firsStepsInCodingExersise;

import java.util.Scanner;

public class FishTank_09 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        int width = Integer.parseInt(scanner.nextLine());

        int height = Integer.parseInt(scanner.nextLine());

        double percent = Double.parseDouble(scanner.nextLine());

        int volumeCm = length * width * height;

        double volumeDm = volumeCm * 0.001;

        double volumeNeeded = volumeDm - (volumeDm * percent / 100);

        System.out.println(volumeNeeded);

    }
}
