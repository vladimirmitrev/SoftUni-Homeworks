package setsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDeck = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));


        int rounds = 0;

        while(!firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            rounds++;
            if(rounds == 50) {
                break;
            }

            int firstPlayerCard = firstDeck.iterator().next();
            firstDeck.remove(firstPlayerCard);

            int secondPlayerCard = secondDeck.iterator().next();
            secondDeck.remove(secondPlayerCard);

            if(firstPlayerCard > secondPlayerCard) {
                firstDeck.add(firstPlayerCard);
                firstDeck.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondDeck.add(firstPlayerCard);
                secondDeck.add(secondPlayerCard);
            }

        }
        if(firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
