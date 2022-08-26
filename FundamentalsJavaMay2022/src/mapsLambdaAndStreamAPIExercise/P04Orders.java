package mapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();

        while(!input.equals("buy")) {
            String[] inputLine = input.split(" ");
            String product = inputLine[0];
            double price = Double.parseDouble(inputLine[1]);
            int quantity = Integer.parseInt(inputLine[2]);

            productsPrice.put(product, price);

            if(!productsQuantity.containsKey(product)) {
                productsQuantity.put(product, quantity);
            } else {
                int currentQty = productsQuantity.get(product);
                productsQuantity.put(product, currentQty + quantity);
//                if (productsPrice.get(product) != price) {
//                    productsPrice.put(product, price);
                }
            input = scanner.nextLine();
            }
        for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {

            String productName = entry.getKey();
            double totalPrice = entry.getValue() * productsQuantity.get(productName);
            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);
        }
    }
}
