package exam9and10March2019;

import java.util.Scanner;

public class P04_GameNumberWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String command = scanner.nextLine();
        boolean war = false;
        int firstPlayerPoints = 0;
        int secondPlayerPoints = 0;

        while (!command.equals("End of game")) {
            int firstPlayerCard = Integer.parseInt(command);
            int secondPlayerCard = Integer.parseInt(scanner.nextLine());

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerPoints = firstPlayerPoints + (firstPlayerCard - secondPlayerCard);

            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerPoints = secondPlayerPoints + (secondPlayerCard - firstPlayerCard);

            } if (firstPlayerCard == secondPlayerCard) {
                war = true;
                System.out.println("Number wars!");
                int lastCard1 = Integer.parseInt(scanner.nextLine());
                int lastCard2 = Integer.parseInt(scanner.nextLine());
                if (lastCard1 > lastCard2) {
                    System.out.printf("%s is winner with %d points", firstName, firstPlayerPoints);
                } else if (lastCard2 > lastCard1) {
                    System.out.printf("%s is winner with %d points", secondName, secondPlayerPoints);
                }
                break;
            }
            command = scanner.nextLine();
        }

        if (command.equals("End of game")) {
            System.out.printf("%s has %d points%n", firstName, firstPlayerPoints);
            System.out.printf("%s has %d points", secondName, secondPlayerPoints);
        }
        }
    }

