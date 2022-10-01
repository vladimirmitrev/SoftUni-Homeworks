package setsAndMapsAdvancedExercise;

import java.util.*;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, HashSet<String>> playersMap = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] inputLine = input.split(": ");
            String name = inputLine[0];
            String[] cards = inputLine[1].split(", ");

            if (!playersMap.containsKey(name)) {
                playersMap.put(name, new HashSet<>());
            }
            for (String card : cards) {
                playersMap.get(name).add(card);
            }
            input = scanner.nextLine();
        }
        for (var player : playersMap.entrySet()) {
            String playerName = player.getKey();
            int points = calculatePoints(player.getValue());
            System.out.printf("%s: %d%n", playerName, points);
        }

        System.out.println();
    }

    private static int calculatePoints(HashSet<String> cards) {
        int points = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            char type = card.charAt(card.length() - 1);

            int cardPoints = getPower(power) * getType(type);
            points += cardPoints;
        }
        return points;
    }


    private static int getType(char type) {
        switch (type) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return 0;
        }
    }

    private static int getPower(String power) {
        switch (power) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(power);
        }

    }
}
