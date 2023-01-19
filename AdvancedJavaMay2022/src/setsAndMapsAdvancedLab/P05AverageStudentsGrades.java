package setsAndMapsAdvancedLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentsMap = new TreeMap<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            Double grade = Double.parseDouble(input[1]);
            if(!studentsMap.containsKey(name)) {
                studentsMap.put(name, new ArrayList<>());
                studentsMap.get(name).add(grade);
            } else {
                studentsMap.get(name).add(grade);
            }
        }

//        studentsMap.entrySet()
//                .stream()
//                .forEach(entry -> {
//                    float average = (float) entry.getValue().stream().mapToDouble(e -> e)
//                            .average().getAsDouble();
//
//                    System.out.print(entry.getKey() + " -> ");
//                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
//                    System.out.printf("(avg: %.2f)%n", average);
//                });

        studentsMap.entrySet()
                .stream()
                .forEach(entry -> {
                    double sum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum += entry.getValue().get(i);

                    }
                    double average = sum / entry.getValue().size();

                    System.out.printf("%s -> ", entry.getKey());
                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n", average);
                });
    }
}
