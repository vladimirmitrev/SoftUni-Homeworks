package examPreparation;

import java.util.Scanner;

public class P02_FootballResults {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstGameResult = scanner.next();
        String secondGameResult = scanner.next();
        String thirdGameResult = scanner.next();

        int won = 0;
        int lose = 0;
        int drawn = 0;

        char firstGameHost = firstGameResult.charAt(0);
        char firstGameGuest = firstGameResult.charAt(2);

        if (firstGameHost > firstGameGuest){
            won++;
        } else if (firstGameGuest > firstGameHost) {
            lose++;
        } else {
            drawn++;
        }
        char secondGameHost = secondGameResult.charAt(0);
        char secondGameGuest = secondGameResult.charAt(2);
        if (secondGameHost > secondGameGuest){
            won++;
        } else if (secondGameGuest > secondGameHost) {
            lose++;
        } else {
            drawn++;
        }
        char thirdGameHost = thirdGameResult.charAt(0);
        char thirdGameGuest = thirdGameResult.charAt(2);
        if (thirdGameHost > thirdGameGuest){
            won++;
        } else if (thirdGameGuest > thirdGameHost) {
            lose++;
        } else {
            drawn++;
        }

        System.out.printf("Team won %d games.%n", won);
        System.out.printf("Team lost %d games.%n", lose);
        System.out.printf("Drawn games: %d%n", drawn);
    }
}
