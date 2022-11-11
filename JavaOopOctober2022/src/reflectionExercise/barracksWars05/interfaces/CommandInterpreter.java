package reflectionExercise.barracksWars05.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
