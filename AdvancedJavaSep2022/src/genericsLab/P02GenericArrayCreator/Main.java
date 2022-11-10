package genericsLab.P02GenericArrayCreator;


public class Main {
    public static void main(String[] args) {

        Integer[] arr = ArrayCreator.create(11, 33);

        for (Integer num : arr) {
            System.out.println(num);
        }

        Integer[] arr2 = ArrayCreator.create(Integer.class, 22, 55);

        for (Integer num2 : arr2) {
            System.out.println(num2);
        }
    }
}
