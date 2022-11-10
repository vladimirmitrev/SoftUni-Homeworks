package reflectionLab.getterAndSetters;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        TreeSet<Method> getters = filterMethodsBy(methods, "get");

        TreeSet<Method> setters = filterMethodsBy(methods, "set");


        //Solutions without deleting "class" from output and without "formatType

        getters
                .forEach(getter -> System.out.printf("%s will return class %s%n", getter.getName(), getter.getReturnType().getName()));
        setters
                .forEach(setter -> System.out.printf("%s and will set field of class %s%n", setter.getName(), setter.getParameterTypes()[0].getTypeName()));

        int modifiers = methods[0].getModifiers();

        String s = Modifier.toString(modifiers);


//        Function<Class<?>, String> formatType = c -> c == int.class ? "class int" : c.toString();
//
//        getters
//                .forEach(getter -> System.out.printf("%s will return %s%n", getter.getName(),
//                        formatType.apply(getter.getReturnType())));
//        setters
//                .forEach(setter -> System.out.printf("%s and will set field of %s%n", setter.getName(),
//                        formatType.apply(setter.getParameterTypes()[0])));
    }

    public static TreeSet<Method> filterMethodsBy(Method[] methods, String filter) {

        return Arrays.stream(methods)
                .filter(method -> method.getName().contains(filter))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(Method::getName))));
    }

     //Whole solution without method "filterMethodBy" and variables

//        Arrays.stream(Reflection.class.getDeclaredMethods())
//            .filter(current->current.getName().startsWith("get"))
//            .sorted(Comparator.comparing(Method::getName))
//            .forEach(getter -> System.out.printf("%s will return class %s%n"
//            ,getter.getName(),getter.getReturnType().getName()));
//
//        Arrays.stream(Reflection.class.getDeclaredMethods())
//            .filter(current->current.getName().startsWith("set"))
//            .sorted(Comparator.comparing(Method::getName))
//            .forEach(setter -> System.out.printf("%s and will set field of class %s%n"
//            ,setter.getName(),setter.getParameters()[0].getType().getName()));

}
