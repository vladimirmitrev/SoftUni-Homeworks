package interfacesAndAbstractionExercise.militaryElite;

import interfacesAndAbstractionExercise.militaryElite.commandClasses.*;
import interfacesAndAbstractionExercise.militaryElite.interfaces.Command;
import interfacesAndAbstractionExercise.militaryElite.interfaces.Soldier;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static final List<Soldier> soldiers = new ArrayList<>();
    public static final Map<String, Command> commands = new HashMap<>() {{
        put("P", new PrivateCommand(soldiers));
        put("L", new LieutenantGeneralCommand(soldiers));
        put("E", new EngineerCommand(soldiers));
        put("C", new CommandoCommand(soldiers));
        put("S", new SpyCommand(soldiers));
    }};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input;
        while (!"End".equals(input = scan.nextLine())) {
            String command = input.trim().substring(0, 1);
            commands.get(command).execute(Arrays.stream(input.split("\\s+")).skip(1)
                    .collect(Collectors.toList()));
        }
        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }
    }
}
