    package programming04FundamentalsFinalExam;

    import java.util.*;

    public class P03HeroesOfCodeAndLogicVIIRetake {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = Integer.parseInt(scanner.nextLine());
            Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                String[] tokens = scanner.nextLine().split(" ");
                String name = tokens[0];
                int health = Integer.parseInt(tokens[1]);
                int manna = Integer.parseInt(tokens[2]);
                if(health > 100) {
                    health = 100;
                }
                if(manna > 200) {
                    manna = 200;
                }
                heroesMap.putIfAbsent(name, new ArrayList<>());
                heroesMap.get(name).add(0, health);
                heroesMap.get(name).add(1, manna);

            }
            String input = scanner.nextLine();

            while (!input.equals("End")) {
                String[] tokens = input.split(" - ");
                String command = tokens[0];
                String heroName = tokens[1];

                switch (command) {
                    case "CastSpell":
                        int mannaNeeded = Integer.parseInt(tokens[2]);
                        String spell = tokens[3];
                        int currentManna = heroesMap.get(heroName).get(1);
                        if(currentManna >= mannaNeeded) {
                            currentManna -= mannaNeeded;
                            heroesMap.get(heroName).set(1, currentManna);
                            System.out.printf("%s has successfully cast %s and now has %d MP!%n"
                                    , heroName, spell, currentManna);
                        } else {
                            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spell);
                        }
                        break;

                    case "TakeDamage":
                        int damage = Integer.parseInt(tokens[2]);
                        String attacker = tokens[3];
                        int currentHealth = heroesMap.get(heroName).get(0);
                        currentHealth -= damage;
                        if (currentHealth > 0) {
                            heroesMap.get(heroName).set(0, currentHealth);
                            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                    , heroName, damage, attacker, currentHealth);
                        } else {
                            heroesMap.remove(heroName);
                            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        }
                        break;

                    case "Recharge":
                        int rechargeAmount = Integer.parseInt(tokens[2]);
                        int mannaDif = 0;
                        int currentMannaRecharge = heroesMap.get(heroName).get(1);
                        int newManna = currentMannaRecharge + rechargeAmount;
                        if(newManna > 200) {
                            mannaDif = 200 - currentMannaRecharge;
                            newManna = 200;
                        } else {
                            mannaDif = rechargeAmount;
                        }
                        heroesMap.get(heroName).set(1, newManna);
                        System.out.printf("%s recharged for %d MP!%n", heroName, mannaDif);
                        break;
                    case "Heal":
                        int healingHealth = Integer.parseInt(tokens[2]);
                        int healthDiff = 0;
                        int currentHealthHeal = heroesMap.get(heroName).get(0);
                        int newHealth = currentHealthHeal + healingHealth;

                        if(newHealth > 100) {
                            healthDiff = 100 - currentHealthHeal ;
                            newHealth = 100;
                        } else {
                            healthDiff = healingHealth;

                        }
                        heroesMap.get(heroName).set(0, newHealth);
                        System.out.printf("%s healed for %d HP!%n", heroName, healthDiff);
                        break;

                }

                input = scanner.nextLine();
            }
            if (heroesMap.size() > 0) {
                heroesMap.entrySet().forEach(entry -> System.out.printf("%s%n" +
                        "  HP: %d%n" +
                        "  MP: %d%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
            }
        }
    }
