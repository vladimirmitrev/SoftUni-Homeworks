package programming04FundamentalsFinalExam;

import java.util.*;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String heroName = tokens[0];
            int health = Integer.parseInt(tokens[1]);
            int manna = Integer.parseInt(tokens[2]);
            heroesMap.putIfAbsent(heroName, new ArrayList<>());
            if (health > 100) {
                health = 100;
            }
            if(manna > 200) {
                manna = 200;
            }
            heroesMap.get(heroName).add(0, health);
            heroesMap.get(heroName).add(1, manna);
        }

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("End")) {
            String[] tokens = inputLine.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];
            int currentHealth = heroesMap.get(heroName).get(0);
            int currentManna = heroesMap.get(heroName).get(1);

            switch (command) {
                case "CastSpell":
                    int mannaNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if(currentManna >= mannaNeeded) {
                        currentManna -= mannaNeeded;
                        heroesMap.get(heroName).set(1, currentManna);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName, spellName,currentManna );
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    currentHealth -= damage;
                    heroesMap.get(heroName).set(0, currentHealth);
                    if(currentHealth > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, currentHealth );
                    } else {
                        heroesMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int rechargeManna = Integer.parseInt(tokens[2]);
                    int totalManna = currentManna + rechargeManna;
                    int rechargeDiff = 0;
                    if (totalManna > 200) {
                        rechargeDiff = 200 - currentManna;
                        totalManna = 200;
                    } else {
                        rechargeDiff = rechargeManna;
                    }
                    heroesMap.get(heroName).set(1, totalManna);
                    System.out.printf("%s recharged for %d MP!%n", heroName, rechargeDiff);
                    break;
                case "Heal":
                    int healingHealth = Integer.parseInt(tokens[2]);
                    int totalHealth = currentHealth + healingHealth;
                    int healingDiff = 0;
                    if (totalHealth > 100) {
                        healingDiff = 100 - currentHealth;
                        totalHealth = 100;
                    } else {
                        healingDiff = healingHealth;
                    }
                    heroesMap.get(heroName).set(0, totalHealth);
                    System.out.printf("%s healed for %d HP!%n", heroName, healingDiff);
                    break;

            }

            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : heroesMap.entrySet()) {
            String name = entry.getKey();
            int health = entry.getValue().get(0);
            int manna = entry.getValue().get(1);

            System.out.println(name);
            System.out.printf("  HP: %d%n", health);
            System.out.printf("  MP: %d%n", manna);
        }

//        heroesMap.forEach((key, value) ->
//                System.out.printf("%s%n" +
//                                "  HP: %d%n" +
//                        "  MP: %d%n", key ,value.get(0), value.get(1)));

    }
}
