package genericsLab.P03GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<String> scale = new Scale<>("A", "B");

        Scale<Integer> intScale = new Scale<>(5, 5);

        System.out.println(scale.getHeavier());

        System.out.println(intScale.getHeavier());

    }
}
