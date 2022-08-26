package programming05FundamentalsMidExam;

import java.util.Scanner;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayRoom = scanner.nextLine().split("\\|");

        int health = 100;
        int bitcoins = 0;
        int roomCount = 0;
        boolean isDead = false;

        for (int i = 0; i < arrayRoom.length ; i++) {
            String[] room = arrayRoom[i].split(" ");
            String command = room[0];
            int num = Integer.parseInt(room[1]);
            roomCount++;

            switch (command) {
                case "potion":
                    int currentHeal = 100 - health;
                    health = health + num;
                    if (health > 100) {
                        health = 100;
                        num = currentHeal;

                }
                    System.out.printf("You healed for %d hp.%n", num);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    bitcoins = num + bitcoins;
                    System.out.printf("You found %d bitcoins.%n", num);
                    break;
                default:
                    health -= num;
                    if(health > 0) {
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", roomCount);
                        isDead = true;
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
