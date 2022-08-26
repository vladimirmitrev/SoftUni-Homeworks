package conditionStatementsExercise;

import java.util.Scanner;

public class Shopping_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int videoCards = Integer.parseInt(scanner.nextLine());
        int processors = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());

        double videoCardsPrice = videoCards * 250;
        double processorsPrice = videoCardsPrice * 0.35 * processors;
        double ramPrice = videoCardsPrice * 0.10 * ram;

        double totalPrice = videoCardsPrice + processorsPrice + ramPrice;


        if (videoCards > processors) {
            totalPrice = totalPrice - (totalPrice * 0.15);
                        }
        if (totalPrice <= budget){
            System.out.printf("You have %.2f leva left!", budget - totalPrice);
        }        else {
            System.out.printf("Not enough money! You need %.2f leva more!", totalPrice - budget);
            }
        }

    }
