package reflectionExercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final Map<String, Method> NAME_METHOD_MAP =
            Arrays.stream(BlackBoxInt.class.getDeclaredMethods())
                    .peek(method -> method.setAccessible(true))
                    .collect(Collectors.toMap(Method::getName, method -> method));

    private static final String END_COMMAND = "END";
    private static final String RESULT = "innerValue";

    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchFieldException {

        final Constructor<BlackBoxInt> constructor =
                BlackBoxInt.class.getDeclaredConstructor(int.class);

        constructor.setAccessible(true);

        final BlackBoxInt blackBoxInt = constructor.newInstance(0);

        String input;

        while (!END_COMMAND.equals(input = SCANNER.nextLine())) {
           final String[] tokens = input.split("_");
           final String methodName = tokens[0];
           final Integer value = Integer.parseInt(tokens[1]);

            Method currentMethod = NAME_METHOD_MAP.get(methodName);
            currentMethod.invoke(blackBoxInt, value);

            final Field result = blackBoxInt.getClass().getDeclaredField(RESULT);
            result.setAccessible(true);

            System.out.println(result.get(blackBoxInt));

        }

        SCANNER.close();



    }
}
