package exam6and7April2019;

import java.util.Scanner;

public class P04_CinemaVoucher2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int voucher = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        double price = 0.0;
        int tickets = 0;
        int others = 0;


        while (!command.equalsIgnoreCase("End")) {
            String name = command;
            int letter1 = name.charAt(0);
            int letter2 = name.charAt(1);
            int lenght = name.length();

            if (lenght > 8) {
                price = letter1 + letter2;
            } else if (lenght <= 8) {
                price = letter1;
            }
            if (voucher - price >= 0) {
                voucher -= price;
                if (lenght>8){
                    tickets++;
                }else if (lenght<=8){
                    others++;
                }
            } else
                break;

            command = scanner.nextLine();
        }



        System.out.printf("%d %n%d", tickets, others);

    }
}

