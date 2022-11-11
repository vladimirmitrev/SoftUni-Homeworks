package reflectionExercise.barracksWars03.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
