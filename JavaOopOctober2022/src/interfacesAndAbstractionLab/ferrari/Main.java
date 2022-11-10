package interfacesAndAbstractionLab.ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String name = input;

        Car car = new Ferrari(name);

        System.out.println(car);
    }
}
