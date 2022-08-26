package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer>secondPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while(firstPlayerCards.size() != 0 && secondPlayerCards.size() != 0) {

            int firstCardFirst = firstPlayerCards.get(0);
            int firstCardSecond = secondPlayerCards.get(0);
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if(firstCardFirst > firstCardSecond) {
                firstPlayerCards.add(firstCardFirst);
                firstPlayerCards.add(firstCardSecond);

            } else if (firstCardSecond > firstCardFirst) {
                secondPlayerCards.add(firstCardSecond);
                secondPlayerCards.add(firstCardFirst);
            }
        }
        if(firstPlayerCards.size() == 0) {
            System.out.printf("Second player wins! Sum: %d", sumOfCards(secondPlayerCards));
        } else if (secondPlayerCards.size() == 0) {
            System.out.printf("First player wins! Sum: %d", sumOfCards(firstPlayerCards));
        }


    }
    private static int sumOfCards (List<Integer> listCards) {
            int sum = 0;
        for (int listCard : listCards) {
                sum += listCard;
        }
        return sum;
    }
}
