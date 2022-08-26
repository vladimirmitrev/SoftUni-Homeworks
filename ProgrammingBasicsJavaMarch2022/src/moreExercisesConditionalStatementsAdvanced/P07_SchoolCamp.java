package moreExercisesConditionalStatementsAdvanced;

import java.util.Scanner;

public class P07_SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int studentQty = Integer.parseInt(scanner.nextLine());
        int nightQty = Integer.parseInt(scanner.nextLine());

        double pricePerNight = 0;
        String sport = "";

        if (groupType.equals("girls") && (season.equals("Winter"))) {
                sport = "Gymnastics";
           } else if (groupType.equals("boys") && (season.equals("Winter"))) {
               sport = "Judo";
           } else if (groupType.equals("mixed") && (season.equals("Winter"))) {
               sport = "Ski";
           }

        if (groupType.equals("girls") && (season.equals("Spring"))) {
            sport = "Athletics";
          } else if (groupType.equals("boys") && (season.equals("Spring"))) {
            sport = "Tennis";
          } else if (groupType.equals("mixed") && (season.equals("Spring"))) {
            sport = "Cycling";
          }

        if (groupType.equals("girls") && (season.equals("Summer"))) {
            sport = "Volleyball";
         } else if (groupType.equals("boys") && (season.equals("Summer"))) {
            sport = "Football";
         } else if (groupType.equals("mixed") && (season.equals("Summer"))) {
            sport = "Swimming";
         }


        switch (season) {
            case"Winter":
                pricePerNight = studentQty * 9.60;
                if (groupType.equals("mixed")) {
                    pricePerNight = studentQty * 10;
                }
                break;
            case"Spring":
                pricePerNight = studentQty * 7.20;
                if (groupType.equals("mixed")) {
                    pricePerNight = studentQty * 9.50;
                }
                break;
            case "Summer":
                pricePerNight = studentQty * 15;
                if (groupType.equals("mixed")) {
                    pricePerNight = studentQty * 20;
                }
                break;
        }
        if (studentQty >= 10 && studentQty < 20){
            pricePerNight = pricePerNight * 0.95;
        } else if (studentQty >= 20 && studentQty < 50) {
            pricePerNight = pricePerNight * 0.85;
        } else if (studentQty >= 50) {
            pricePerNight = pricePerNight * 0.50;
        }
        double totalPrice = pricePerNight * nightQty;

        System.out.printf("%s %.2f lv.", sport, totalPrice);
    }
}
