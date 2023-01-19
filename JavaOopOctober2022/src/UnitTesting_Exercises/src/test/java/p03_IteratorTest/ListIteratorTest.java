package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private String[] NAMES = {"Angel", "Mariya", "Deya", "Emanuil"};

    @Before
    public void prepare() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testCreateIteratorWithNullShouldThrow() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNext() {

        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());

    }

    @Test
    public void testMove() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test (expected = IllegalStateException.class)
    public void testEmptyListShouldThrow() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintSuccess() {
        int index = 0;
        while (listIterator.hasNext()) {
            assertEquals(NAMES[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }
}