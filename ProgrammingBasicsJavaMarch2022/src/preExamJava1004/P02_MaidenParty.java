package preExamJava1004;

import java.util.Scanner;

public class P02_MaidenParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double partyPrice = Double.parseDouble(scanner.nextLine());
        int loveQty = Integer.parseInt(scanner.nextLine());
        int rosesQty = Integer.parseInt(scanner.nextLine());
        int keysChainQty = Integer.parseInt(scanner.nextLine());
        int caricaturesQty = Integer.parseInt(scanner.nextLine());
        int lucksQty = Integer.parseInt(scanner.nextLine());

        double lovePrice = loveQty * 0.60;
        double rosesPrice = rosesQty * 7.20;
        double keyChainPrice = keysChainQty * 3.60  ;
        double caricaturePrice = caricaturesQty * 18.20;
        double luckyPrice = lucksQty * 22;

        double totalPrice = lovePrice + rosesPrice + keyChainPrice + caricaturePrice + luckyPrice;
        double totalQty = loveQty + rosesQty + keysChainQty + caricaturesQty + lucksQty;
        if (totalQty >= 25) {
            totalPrice = totalPrice - (totalPrice * 0.35);
        }
        double finalPrice = totalPrice - (totalPrice * 0.10);
        if (finalPrice > partyPrice) {
            System.out.printf("Yes! %.2f lv left.", finalPrice - partyPrice);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", Math.abs(partyPrice - finalPrice));
        }

    }
}
