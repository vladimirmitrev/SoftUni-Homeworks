package reflectionExercise.barracksWars05.core;

import reflectionExercise.barracksWars05.interfaces.CommandInterpreter;
import reflectionExercise.barracksWars05.interfaces.Executable;
import reflectionExercise.barracksWars05.interfaces.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

    private final CommandInterpreter commandInterpreter;

    private static final String END_COMMAND = "fight";

    public Engine(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!END_COMMAND.equals(input = reader.readLine())) {
            try {
               final String[] data = input.split("\\s+");

               final String token = data[0];

                final Executable command = this.commandInterpreter.interpretCommand(data, token);

                System.out.println(command.execute());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        reader.close();
    }
}
