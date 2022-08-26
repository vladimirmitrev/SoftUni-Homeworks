package arraysExercise;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());

        int[] people = new int[wagons];

        int sum = 0;
        for (int i = 0; i < people.length; i++) {
            people[i] = Integer.parseInt(scanner.nextLine());
            sum += people[i];
            System.out.print(people[i] + " ");
        }
        System.out.printf("%n%d", sum);
    }
}