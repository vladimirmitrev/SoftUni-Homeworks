package exam9and10March2019;

import java.util.Scanner;

public class P06_HighJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wantedHeight = Integer.parseInt(scanner.nextLine());

        int failTimes = 0;
        int totalJumpTimes = 0;
        boolean end = false;

        for (int actHeight = wantedHeight - 30; actHeight <= wantedHeight; actHeight += 5) {

            for (int i = 1; i <= 3 ; i++) {

                int jumpHeight = Integer.parseInt(scanner.nextLine());
                if (jumpHeight > actHeight) {

                    totalJumpTimes++;
                    failTimes = 0;
                    break;

                } else {
                    failTimes++;
                    totalJumpTimes++;
                }
            }
            if (failTimes == 3) {
                System.out.printf("Tihomir failed at %dcm after %d jumps.", actHeight, totalJumpTimes);
                return;
            }
        }
        if (!end) {
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", wantedHeight, totalJumpTimes);
        }

    }

}
