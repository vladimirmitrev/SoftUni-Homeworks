package setsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeSet<String> vips = new TreeSet<>();
        Set<String> regulars = new TreeSet<>();
        while (!input.equals("PARTY")) {
            char firstChart = input.charAt(0);
            if(Character.isDigit(firstChart)) {
                vips.add(input);
            } else {
                regulars.add(input);
            }
            input = scanner.nextLine();
        }
        while (!input.equals("END")) {
            vips.remove(input);
            regulars.remove(input);

            input = scanner.nextLine();
        }
        System.out.println(vips.size() + regulars.size());
        if(!vips.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), vips));
        }
        if (!regulars.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), regulars));
        }
    }
}
