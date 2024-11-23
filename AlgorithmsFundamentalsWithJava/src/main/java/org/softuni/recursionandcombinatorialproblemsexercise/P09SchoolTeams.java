package org.softuni.recursionandcombinatorialproblemsexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P09SchoolTeams {

    public static String[] girls;
    public static String[] girlsCombinations = new String[3];
    public static String[] boys;
    public static String[] boysCombinations = new String[2];
//    public static List<String> allGrls = new ArrayList<>();
//    public static List<String> allBoys = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        girls = reader.readLine().split(", ");
        boys = reader.readLine().split(", ");

        combineGirls(0, 0);
//        combineBoys(0, 0);

//        for (String allGrl : allGrls) {
//            for (String allBoy : allBoys) {
//                System.out.println(allGrl + ", " +  allBoy);
//            }
//        }
    }

    private static void combineGirls(int index, int start) {
        if (index == girlsCombinations.length) {
            combineBoys(0, 0);
//            allGrls.add(String.join(", ", girlsCombinations));
        } else {
            for (int i = start; i < girls.length; i++) {
                girlsCombinations[index] = girls[i];
                combineGirls(index + 1, i + 1);
            }
        }
    }
    private static void combineBoys(int index, int start) {
        if (index == boysCombinations.length) {
            printTeam();
//            allBoys.add(String.join(", ", boysCombinations));
        } else {
            for (int i = start; i < boys.length; i++) {
                boysCombinations[index] = boys[i];
                combineBoys(index + 1, i + 1);
            }
        }
    }

    private static void printTeam() {
        StringBuilder output = new StringBuilder();
        output.append(String.join(", ", girlsCombinations))
                .append(", ")
                .append(String.join(", ", boysCombinations));

        System.out.println(output);
    }
}
