package arraysExercise;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstRow = scanner.nextLine();
        String secondRow = scanner.nextLine();

        String[] firstArray = firstRow.split(" ");
        String[] secondArray = secondRow.split(" ");

        for (String secondElement : firstArray) {
            for (String firstElement : secondArray) {
                if (firstElement.equals(secondElement)) {
                    System.out.print(firstElement + " ");
                    break;
                }
            }
        }
    }
}
