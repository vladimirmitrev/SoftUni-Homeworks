package exam20And21April2019;

import java.util.Scanner;

public class adasdas {

    public class FoodDelivery {
        public static void main(String[] args)
        { Scanner scanner = new Scanner(System.in);
            int people = Integer.parseInt(scanner.nextLine());
            int count = 0;
            double allPrice = 0;
            double basketPrice = 1.50;
            double wreathPrice = 3.80; double chocolateBunnyPrice = 7;
            double average = 0;
            for (int i = 1; i <= people; i++)
            {
                String command = scanner.nextLine();
                while (!"Finish".equals(command)) { if (command.equals("basket")) { allPrice += basketPrice; count++; } if (command.equals("wreath")) { allPrice += wreathPrice; count++; } if (command.equals("chocolate bunny")) { allPrice += chocolateBunnyPrice; count++; } command = scanner.nextLine(); } if (count % 2 == 0) { double percentPrice = allPrice * 0.2; allPrice = allPrice - percentPrice; } average += allPrice; System.out.printf("You purchased %d items for %.2f leva.\n",count,average); } if (people > 1) { average /= people; } System.out.printf("Average bill per client is: %.2f leva.",average); } }
}
