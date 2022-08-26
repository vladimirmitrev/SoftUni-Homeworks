package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPeople = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        double courses = Math.ceil(numberPeople * 1.0 / elevatorCapacity);

        System.out.printf("%.0f", courses);
    }
}
