package dataStructuresWorkshopExercise;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.get(2));
        System.out.println(list.get(0));
        System.out.println(list.get(3));
        System.out.println(list.get(1));



        Arrays.stream(list.toArray()).forEach(System.out::println);

    }
}
