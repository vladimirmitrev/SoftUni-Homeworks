package dataStructuresWorkshopLab;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {



//        SmartArray

        SmartArray smartArray = new SmartArray();

        IntStream.rangeClosed(1, 5000)
                .forEach(smartArray::add);

        IntStream.rangeClosed(1, 4999).forEach(i -> smartArray.remove(0));



            smartArray.forEach(System.out::println);




//
//        MyStack stack = new MyStack();
//
//        stack.push(13);
//        stack.push(4);
//        stack.push(5);
//        stack.push(8);
//
//        stack.pop();
//        stack.pop();
//
//        stack.forEach(System.out::println);
    }
}
