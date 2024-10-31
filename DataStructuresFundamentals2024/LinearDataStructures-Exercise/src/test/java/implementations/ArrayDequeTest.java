package implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
        public void testArrayDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

//        deque.offer(13);
//        deque.offer(14);
//        deque.offer(15);
//        deque.offer(16);
//        deque.offer(17);
//
//        for (Integer integer : deque) {
//            System.out.println(integer);
//        }

        deque.add(13);
        deque.add(14);
        deque.add(15);
        deque.add(16);

        deque.remove(2);
//        System.out.println(deque.remove(Integer.valueOf(22)));

        for (Integer integer : deque) {
            System.out.println(integer);
        }

//        System.out.println(deque.poll());
    }

}