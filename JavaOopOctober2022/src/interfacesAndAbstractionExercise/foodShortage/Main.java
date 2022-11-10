package interfacesAndAbstractionExercise.foodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String input = scanner.nextLine();
            String[] inputParts = input.split(" ");
            String name = inputParts[0];
            Buyer buyer;
            if(inputParts.length == 3) {
                int rebelAge = Integer.parseInt(inputParts[1]);
                String group = inputParts[2];
                buyer = new Rebel(name, rebelAge, group);
                buyers.put(name, buyer);
            } else {
                int citizenAge = Integer.parseInt(inputParts[1]);
                String citizenId = inputParts[2];
                String citizenBirthDate = inputParts[3];
                buyer = new Citizen(name, citizenAge, citizenId, citizenBirthDate);
                buyers.put(name, buyer);

            }
        }
        String buyersName = scanner.nextLine();

        while (!"End".equals(buyersName)) {
            Buyer buyer = buyers.get(buyersName);

            if(buyer != null) {
                buyer.buyFood();
            }
            buyersName = scanner.nextLine();
        }
        int totalFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();

        System.out.println(totalFood);
    }

}
