package moreExercisesConditionalStatementsAdvanced;

import java.util.Scanner;

public class P01_MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String ticketType = scanner.nextLine();
        int peopleCount = Integer.parseInt(scanner.nextLine());

        double ticketPrice = 0;
        double budgetLeft = 0;
        double sum = 0;

        if(peopleCount >= 1 && peopleCount <= 4) {
            budgetLeft = budget * 0.25;
        } else if (peopleCount >=5 && peopleCount <= 9) {
            budgetLeft = budget * 0.40;
        } else if (peopleCount >=10 && peopleCount <= 24) {
            budgetLeft = budget * 0.50;
        } else if (peopleCount >=25 && peopleCount <= 49) {
            budgetLeft = budget * 0.60;
        } else if (peopleCount >= 50){
            budgetLeft = budget * 0.75;
        }
        switch (ticketType) {
            case "Normal":
                ticketPrice = peopleCount * 249.99;
                break;
            case "VIP":
                ticketPrice = peopleCount * 499.99;
                break;
        }
            sum = budgetLeft - ticketPrice;
            double mooneyNeeded = ticketPrice - budgetLeft;


        if (budgetLeft >= ticketPrice) {
            System.out.printf("Yes! You have %.2f leva left.", sum);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", mooneyNeeded);
        }
    }
}
