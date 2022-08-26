package exam6and7April2019;

import java.util.Scanner;

public class P06_CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        int countTotalTickets = 0;

        int countStandard = 0;
        int countStudents = 0;
        int countKids = 0;

        while (!command.equals("Finish")) {
            String movie = command;
            int seats = Integer.parseInt(scanner.nextLine());

            int countCurrentTickets = 0;
            String ticketsType = scanner.nextLine();

            while(!ticketsType.equals("End")) {
                countCurrentTickets++;
                countTotalTickets++;

                if(ticketsType.equals("student")) {
                    countStudents++;
                } else if (ticketsType.equals("standard")) {
                    countStandard++;
                } else if (ticketsType.equals("kid")) {
                    countKids++;
                }

                if(countCurrentTickets >= seats) {
                    break;
                }
                ticketsType = scanner.nextLine();

            }

            System.out.printf("%s - %.2f%% full.%n", movie, countCurrentTickets * 1.0 / seats * 100 );

            command = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n", countTotalTickets);
        System.out.printf("%.2f%% student tickets.%n", countStudents * 1.0 / countTotalTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n", countStandard * 1.0 / countTotalTickets * 100);
        System.out.printf("%.2f%% kids tickets.%n", countKids * 1.0 / countTotalTickets * 100);
    }
}

