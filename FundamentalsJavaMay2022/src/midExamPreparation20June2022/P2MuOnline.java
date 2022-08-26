package midExamPreparation20June2022;

import java.util.Scanner;

public class P2MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] roomArr = scanner.nextLine().split("\\|");

        int health = 100;
        int bitcoins = 0;
        boolean isDead = false;

        for (int i = 0; i < roomArr.length; i++) {
            String[] room = roomArr[i].split(" ");
            String command = room[0];
            int num = Integer.parseInt(room[1]);

            switch (command) {
                case "potion":
                    int healthDiff = 100 - health;
                    health += num;
                    if (health > 100) {
                        health = 100;
                        num = healthDiff;
                    }
                    System.out.printf("You healed for %d hp.%n", num);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    System.out.printf("You found %d bitcoins.%n", num);
                    bitcoins += num;
                    break;
                default:
                    health -= num;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        isDead = true;
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", i + 1);
                    }
                    break;
            }
            if (isDead) {
                break;
            }
        }
        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", health);
        }
    }
}
