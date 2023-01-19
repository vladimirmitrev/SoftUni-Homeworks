package exam02_Retake18Aug2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlatesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(licensePlatesQueue::offer);

        ArrayDeque<Integer> carsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(carsStack::push);

        int countRegisteredCars = 0;
        int countOfDays = 0;
        int licencesNotUsed = 0;

        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {
            countOfDays++;
            int licenceValue = licensePlatesQueue.poll();
            int carsValue = carsStack.pop();

            if ((licenceValue / 2) > carsValue) {
                licensePlatesQueue.addLast(licenceValue - (carsValue * 2));
                countRegisteredCars += carsValue;
            } else if ((carsValue * 2) > licenceValue) {
                int carsLeft = carsValue - (licenceValue / 2);
                carsStack.addLast(carsLeft);
                countRegisteredCars += (licenceValue / 2);
            } else {
                countRegisteredCars += carsValue;
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", countRegisteredCars, countOfDays);

        if (!licensePlatesQueue.isEmpty()) {
            while (!licensePlatesQueue.isEmpty()) {
                licencesNotUsed += licensePlatesQueue.poll();
            }
            System.out.printf("%d license plates remain!", licencesNotUsed);

        } else if (!carsStack.isEmpty()) {
            int sumOfCarsWithoutPlates = 0;
            while (!carsStack.isEmpty()) {
                sumOfCarsWithoutPlates += carsStack.pop();
            }
            System.out.printf("%d cars remain without license plates!", sumOfCarsWithoutPlates);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
