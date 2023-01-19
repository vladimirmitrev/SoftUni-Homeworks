package setsAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        Map<String, Map<String,Integer>>usersInfo=new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[]input=scanner.nextLine().split("\\s+");
            usersInfo.putIfAbsent(input[1],new TreeMap<>());
            usersInfo.get(input[1]).put(input[0], !usersInfo.get(input[1]).containsKey(input[0])
                    ? Integer.parseInt(input[2]) : usersInfo.get(input[1]).get(input[0]) + Integer.parseInt(input[2]));
        }
        usersInfo.forEach((key, value) -> System.out.printf("%s: %d [%s]%n", key,
                value.values().stream().mapToInt(v -> v).sum(),String.join(", ", value.keySet())));
    }
}
