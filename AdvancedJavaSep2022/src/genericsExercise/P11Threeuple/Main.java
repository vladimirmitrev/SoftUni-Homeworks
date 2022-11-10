package genericsExercise.P11Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String firstName = input[0];
        String lastName = input[1];
        String address = input[2];
        String town = input[3];

        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(firstName + " " + lastName, address, town);
        System.out.println(firstThreeuple);

        input = scanner.nextLine().split(" ");
        String name = input[0];
        int littersBeer = Integer.parseInt(input[1]);
        String condition = input[2];
        boolean isTrue = false;

        Threeuple<String, Integer, Boolean> second = new Threeuple<>(name, littersBeer, isTrue);
        if(condition.equals("drunk")) {
            second.setThird(true);
        } else {
            second.setThird(false);
        }
        System.out.println(second);

        input = scanner.nextLine().split(" ");
        String name3 = input[0];
        double balance = Double.parseDouble(input[1]);
        String bankName = input[2];

        Threeuple<String, Double, String> third = new Threeuple<>(name3, balance, bankName);
        System.out.println(third);

    }
}
