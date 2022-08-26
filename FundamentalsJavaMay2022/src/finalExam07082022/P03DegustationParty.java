package finalExam07082022;

import java.util.*;

public class P03DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> guestMap = new LinkedHashMap<>();
        List<String> mealList = new ArrayList<>();
        int unlikedMeals = 0;
        while (!input.equals("Stop")) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String guestName = tokens[1];
            String meal = tokens[2];

            switch (command) {
                case "Like":
                    if(!guestMap.containsKey(guestName)) {
                        guestMap.put(guestName, new ArrayList<>());
                        guestMap.get(guestName).add(meal);
                    } else if (!guestMap.get(guestName).contains(meal)) {
                        guestMap.get(guestName).add(meal);
                    }
                    break;

                case "Dislike":

                    if(guestMap.containsKey(guestName))  {
                        if(guestMap.get(guestName).contains(meal)) {
                            guestMap.get(guestName).remove(meal);
                            unlikedMeals++;
                            System.out.printf("%s doesn't like the %s.%n", guestName, meal);
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guestName, meal);
                        }
                    } else {
                        System.out.printf("%s is not at the party.%n", guestName);
                    }

                    break;
            }

            input = scanner.nextLine();
        }
       guestMap.forEach((key, value) -> System.out.println(key + ": " + String.join(", ", value)));

        System.out.printf("Unliked meals: %d%n", unlikedMeals);

    }
}
