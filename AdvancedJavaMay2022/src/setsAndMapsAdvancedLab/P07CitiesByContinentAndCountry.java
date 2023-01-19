package setsAndMapsAdvancedLab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> map = new LinkedHashMap<>();

        while (n-- > 0) {
            String input = scanner.nextLine();
            String[] inputLine = input.split(" ");
            String continent = inputLine[0];
            String country = inputLine[1];
            String city = inputLine[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, ArrayList<String>> countyMap = map.get(continent);
            countyMap.putIfAbsent(country, new ArrayList<>());
            ArrayList<String> citiesList = countyMap.get(country);
            citiesList.add(city);
        }
        map.forEach((continent, country) -> {

            System.out.println(continent + ":");

            country.entrySet()
                    .forEach(e -> {
                        System.out.println("  " + e.getKey() + " -> " + String.join(", ", e.getValue()));
                    });
        });
//        map.entrySet()
//                .forEach(entry -> {
//                    String continent = entry.getKey();
//                    LinkedHashMap<String, ArrayList<String>> country = entry.getValue();
//
//                    System.out.println(continent + ":");
//
//                    country.entrySet()
//                            .forEach(e -> {
//                                System.out.println("  " + e.getKey() + " -> " + String.join(", ", e.getValue()));
//                            });
//                });

//        for (var continent : map.entrySet()) {
//            System.out.printf("%s:%n", continent.getKey());
//            LinkedHashMap<String, ArrayList<String>> countryMap = continent.getValue();
//
//            for (var country : countryMap.entrySet()) {
//                System.out.printf("%s -> ", country.getKey());
//                ArrayList<String> city = country.getValue();
//                System.out.println(String.join(", ", city));
//            }
//        }
//    }
    }
}
