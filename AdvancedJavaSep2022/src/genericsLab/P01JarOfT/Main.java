package genericsLab.P01JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<String> pickleJar = new Jar<>();

        pickleJar.add("firstPickle");
        pickleJar.add("secondPickle");

        System.out.println(pickleJar.remove());
        System.out.println(pickleJar.remove());

    }
}
