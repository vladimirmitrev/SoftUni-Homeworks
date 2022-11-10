package reflectionLab.highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.TreeSet;

import static reflectionLab.highQualityMistakes.ReflectionUtils.*;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Field[] declaredFields = clazz.getDeclaredFields();

        TreeSet<Field> fields = collectByName(Arrays.stream(declaredFields));

        filterMembers(fields.stream(), f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        TreeSet<Method> getters = collectByName(filterMembersByName(methods, "get"));

        filterMembers(getters.stream(), g -> !Modifier.isPublic(g.getModifiers()))
                .forEach(g -> System.out.printf("%s public!%n", g.getName()));

        TreeSet<Method> setters = collectByName(filterMembersByName(methods, "set"));

        filterMembers(setters.stream(), s -> !Modifier.isPrivate(s.getModifiers()))
                .forEach(s -> System.out.printf("%s have to be private!%n", s.getName()));


//        Arrays.stream(Reflection.class.getDeclaredFields())
//                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
//                .sorted(Comparator.comparing(Field::getName))
//                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));
//
//        Arrays.stream(Reflection.class.getDeclaredMethods())
//                .filter(method -> method.getName().startsWith("get"))
//                .sorted(Comparator.comparing(Method::getName))
//                .filter(getter -> !Modifier.isPublic(getter.getModifiers()))
//                .forEach(getter -> System.out.printf("%s have to be public!%n", getter.getName()));
//
//        Arrays.stream(Reflection.class.getDeclaredMethods())
//                .filter(method -> method.getName().startsWith("set"))
//                .sorted(Comparator.comparing(Method::getName))
//                .filter(setter -> !Modifier.isPrivate(setter.getModifiers()))
//                .forEach(setter -> System.out.printf("%s have to be private!%n", setter.getName()));

    }

}
