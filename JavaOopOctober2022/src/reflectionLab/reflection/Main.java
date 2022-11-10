package reflectionLab.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);

        Class<?> superclass = clazz.getSuperclass();

        System.out.println(superclass);

        Class<?>[] interfaces = clazz.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Constructor<Reflection> declaredConstructor = clazz.getDeclaredConstructor();

        Object newInstance = declaredConstructor.newInstance();

        System.out.println(newInstance);


    }
}
