package advancedConditionStatementExercise;

import java.util.Scanner;

public class OnTimeForTheExam_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMin = Integer.parseInt(scanner.nextLine());
        int arriveHour = Integer.parseInt(scanner.nextLine());
        int arriveMin = Integer.parseInt(scanner.nextLine());

        int examTimeInMin = examHour * 60 + examMin;
        int arriveTimeInMin = arriveHour * 60 + arriveMin;

        int difference = Math.abs(examTimeInMin - arriveTimeInMin);

        if (examTimeInMin < arriveTimeInMin) {
            System.out.println("Late");
            if (difference >= 60) {
                int hour = difference / 60;
                int min = difference % 60;
                System.out.printf("%d:%02d hours after the start", hour, min);
            } else {
                System.out.printf("%d minutes after the start", difference);
            }
        } else if (examTimeInMin == arriveTimeInMin || difference <= 30) {
            System.out.println("On time");
            if (difference >= 1 && difference <= 30) {
                System.out.printf("%d minutes before the start", difference);
            }
            } else {
                System.out.println("Early");
                if (difference >= 60) {
                    int hour = difference / 60;
                    int min = difference % 60;
                    System.out.printf("%d:%02d hours before the start", hour, min);
                } else {
                    System.out.printf("%d minutes before the start", difference);
                }
            }
        }
    }
