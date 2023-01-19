package setsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Double[]> graduationMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] scoresStrings = scanner.nextLine().split(" ");
            Double[] scores = new Double[scoresStrings.length];

            for (int j = 0; j < scoresStrings.length; j++) {
                scores[j] = Double.parseDouble(scoresStrings[j]);

            }
            graduationMap.put(name, scores);

        }
        graduationMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    var avgGrade = Arrays.stream(entry.getValue())
                            .reduce(Double::sum).orElse(0d) / entry.getValue().length;
                    System.out.println( entry.getKey() + " is graduated with "+ avgGrade);
                });

//        graduationMap.entrySet()
//                .stream().forEach(entry -> {
//                    float average = (float) Arrays.stream(entry.getValue())
//                            .mapToDouble(e -> e).average().getAsDouble();
//                    DecimalFormat df = new DecimalFormat("#.######");
//                    System.out.printf("%s is graduated with %f", entry.getKey());
//                    System.out.println(df.format(average));
//
//                });
    }
}
