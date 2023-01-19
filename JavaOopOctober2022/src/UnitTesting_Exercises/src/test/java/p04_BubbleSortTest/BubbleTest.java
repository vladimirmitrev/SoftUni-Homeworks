package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testSort() {

        int[] numbers = {4, 8, -7, 15, 100, 55};

        Bubble.sort(numbers);

        int[] sortedArray = {-7, 4, 8, 15, 55, 100};

        assertArrayEquals(sortedArray, numbers);
    }
}