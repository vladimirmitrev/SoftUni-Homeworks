package programming01FundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int allPeople = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int peopleOnCurrentWagon = 0;
        int peopleOnTheLift = 0;
        boolean noMorePeople = false;

        for (int i = 0; i < wagons.length; i++) {
            while (wagons[i] < 4) {
                wagons[i]++;
                peopleOnCurrentWagon++;
                if (peopleOnTheLift + peopleOnCurrentWagon == allPeople) {
                    noMorePeople = true;
                    break;
                }
            }
            peopleOnTheLift += peopleOnCurrentWagon;
            if (noMorePeople) {
                break;
            }
            peopleOnCurrentWagon = 0;
        }

        if (allPeople > peopleOnTheLift) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", allPeople - peopleOnTheLift);
            System.out.println(Arrays.toString(wagons).replaceAll("[\\[\\],]", ""));
        } else if (allPeople < wagons.length * 4 && noMorePeople ){
            System.out.println("The lift has empty spots!");
            System.out.println(Arrays.toString(wagons).replaceAll("[\\[\\],]", ""));
        } else if (noMorePeople && allPeople <= 0) {
            System.out.println(Arrays.toString(wagons).replaceAll("[\\[\\],]", ""));
        }
    }
}
