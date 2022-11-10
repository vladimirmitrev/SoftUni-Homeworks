package algorithmsWorkshop.P03SumOfCoins;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Map<Integer, Integer> usedCoins;

        try {
            usedCoins = chooseCoins(coins, targetSum);

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
       int index = coins.length - 1;

       Map<Integer, Integer> coinsAmount = new LinkedHashMap<>();

       while (targetSum != 0 && index >= 0) {
           int coin = coins[index--];
           int coinsToTake = targetSum / coin;
           targetSum = targetSum % coin;

           if(coinsToTake != 0) {
               coinsAmount.put(coin, coinsToTake);
           }
       }

       if(targetSum != 0) {
           throw new IllegalStateException("Error");
       }
       return coinsAmount;
    }
}