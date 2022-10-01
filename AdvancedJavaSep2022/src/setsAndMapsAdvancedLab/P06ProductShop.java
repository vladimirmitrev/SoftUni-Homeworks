package setsAndMapsAdvancedLab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> storesMap = new TreeMap<>();


        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String storeName = tokens[0];
            String product = tokens[1];
            Double price = Double.parseDouble(tokens[2]);

            if (!storesMap.containsKey(storeName)) {
                storesMap.put(storeName, new LinkedHashMap<>());
            }
            if (!storesMap.containsKey(product)) {
                storesMap.get(storeName).put(product, price);

            }

            input = scanner.nextLine();
        }

        for (var storeName : storesMap.entrySet()) {
            System.out.printf("%s-> %n", storeName.getKey());

            LinkedHashMap<String, Double> productsMap = storeName.getValue();

            for (var product : productsMap.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",product.getKey(), product.getValue());
            }
        }

//        for (String storeName : storesMap.keySet()) {
//            System.out.printf("%s-> %n", storeName);
//
//            LinkedHashMap<String, Double> productsMap = storesMap.get(storeName);
//
//            for (String productName : productsMap.keySet()) {
//                System.out.printf("Product: %s, Price: %.1f%n", productName, productsMap.get(productName));
//
//            }
//        }


//            for (Map.Entry<String, Double> product : productsMap.entrySet()) {
//                System.out.printf("Product: %s, Price: %.1f%n",product.getKey(), product.getValue());
//            }
    }
}
