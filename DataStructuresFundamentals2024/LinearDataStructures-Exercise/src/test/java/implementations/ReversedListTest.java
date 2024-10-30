package implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReversedListTest {

    @Test
    public void testReversedList() {
        ReversedList<Integer> numbers = new ReversedList<>();

        numbers.add(13);
        numbers.add(14);
        numbers.add(15);
        numbers.add(16);
        numbers.add(17);

        System.out.println(numbers.capacity());

        numbers.removeAt(3);

        for (Integer number : numbers) {
            System.out.println(number);
        }

    }

}