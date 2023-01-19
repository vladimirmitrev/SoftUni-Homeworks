package setsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> usersMap = new TreeMap<>();

        while (!input.equals("end")) {
            String[] inputLine = input.split(" ");
            String firstWord = inputLine[0];
            String lastWord = inputLine[2];
            String ipAddress = firstWord.substring(3);
            String user = lastWord.substring(5);

            if (!usersMap.containsKey(user)) {
                usersMap.put(user, new LinkedHashMap<>());
            }
            if (!usersMap.get(user).containsKey(ipAddress)) {
                usersMap.get(user).put(ipAddress, 1);
            } else {
                int countAttacks = usersMap.get(user).get(ipAddress) + 1;
                usersMap.get(user).put(ipAddress, countAttacks);
            }


            input = scanner.nextLine();
        }

        for (var user : usersMap.entrySet()) {
            System.out.printf("%s: %n", user.getKey());
            LinkedHashMap<String, Integer> addressesMap = user.getValue();
            StringBuilder sb = new StringBuilder();

            for (var address : addressesMap.entrySet()) {
                String formattedAttack = String.format("%s => %d, ", address.getKey(), address.getValue());
                sb.append(formattedAttack);
            }
            String finalOutput = sb.substring(0, sb.length() - 2);
            finalOutput = finalOutput + ".";
            System.out.println(finalOutput);
        }
    }
}
