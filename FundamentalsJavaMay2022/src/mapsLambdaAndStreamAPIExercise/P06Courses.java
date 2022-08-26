package mapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> courseMap = new LinkedHashMap<>();

        while(!input.equals("end")) {
            String course = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];

            if(!courseMap.containsKey(course)) {
                courseMap.put(course, new ArrayList<>());
            }
            courseMap.get(course).add(studentName);

            input = scanner.nextLine();
        }
        courseMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
            entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));
        });

    }
}
