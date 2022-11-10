package inheritanceLab.randomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList list = new RandomArrayList();

        list.add(11);
        list.add(22);
        list.add(55);
        list.add(77);

        System.out.println(list.getRandomElement());
        System.out.println(list.getRandomElement());
        System.out.println(list.getRandomElement());
        System.out.println(list.getRandomElement());


    }
}
