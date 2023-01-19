package exam02_Retake18Aug2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01KAT2 {
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

        int daysCount = 0;
        int registeredCars = 0;
        int licenseNotUsed = 0;
        int carsWithoutPlate = 0;


        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {
            daysCount++;
            int licenceValue = licensePlatesQueue.poll();
            int carsValue = carsStack.pop();

           if(licenceValue / 2 > carsValue) {
               licensePlatesQueue.addLast(licenceValue - (carsValue * 2));
               registeredCars += carsValue;
           } else if((carsValue * 2) > licenceValue) {
               int carsLeft = carsValue - (licenceValue / 2);
               carsStack.addLast(carsLeft);
               registeredCars += (licenceValue / 2);
           } else {
               registeredCars += carsValue;
           }
        }

        System.out.printf("%d cars were registered for %d days!%n", registeredCars, daysCount);

        if(!licensePlatesQueue.isEmpty()) {
            for (Integer plate : licensePlatesQueue) {
                    licenseNotUsed += plate;
            }
            System.out.printf("%d license plates remain!", licenseNotUsed);

        } else if (!carsStack.isEmpty()) {
            for (Integer car : carsStack) {
                carsWithoutPlate += car;
            }
            System.out.printf("%d cars remain without license plates!", carsWithoutPlate);

        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
