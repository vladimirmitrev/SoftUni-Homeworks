package encapsulationExercise.shoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleMap = new LinkedHashMap<>();
        Map<String, Product> productMap = new LinkedHashMap<>();

        String[] peopleInput = scanner.nextLine().split(";");

        for (String personData : peopleInput) {
            String[] personParts = personData.split("=");
            String personName = personParts[0];
            double money = Double.parseDouble(personParts[1]);

            try {
                Person person = new Person(personName, money);
                peopleMap.put(personName, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String[] productsInput = scanner.nextLine().split(";");

        for (String productData : productsInput) {
            String[] productsParts = productData.split("=");
            String productName = productsParts[0];
            double cost = Double.parseDouble(productsParts[1]);

            try {
                Product product = new Product(productName, cost);
                productMap.put(productName, product);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] commandParts = command.split(" ");
            String personName = commandParts[0];
            String productName = commandParts[1];

            Person buyer = peopleMap.get(personName);
            Product productToBuy = productMap.get(productName);

            try {
                buyer.buyProduct(productToBuy);
                System.out.printf("%s bought %s%n", buyer.getName(), productToBuy.getName() );

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }
        peopleMap.values().forEach(System.out::println);


    }
}
