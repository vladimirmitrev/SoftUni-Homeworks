package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<String> customLinkedList;

    @Before
    public void prepare() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void testAddSuccess() {
        customLinkedList.add("Pesho");
        assertEquals("Pesho", customLinkedList.get(0));
    }
    @Test
    public void testAddToNonEmptyList() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Ivan");
        assertEquals("Ivan", customLinkedList.get(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetShouldThrowForBigIndex() {
        customLinkedList.get(100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetShouldThrowForNegativeIndex() {
        customLinkedList.get(-100);
    }


}