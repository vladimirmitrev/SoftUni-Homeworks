package mapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> companiesMap = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split(" -> ");

            if(companiesMap.containsKey(data[0])) {
                List<String> employees = companiesMap.get(data[0]);
                if(!employees.contains(data[1])) {
                    employees.add(data[1]);
                }
            } else {
                List<String> employees = new ArrayList<>();
                employees.add(data[1]);
                companiesMap.put(data[0], employees );
            }

            input = scanner.nextLine();
        }
        companiesMap.entrySet()//stream().sorted(Map.Entry.comparingByKey())
                .forEach(company -> {
                    System.out.println(company.getKey());
                    company.getValue().forEach(employee -> System.out.println("-- " + employee));
                });
    }
}
