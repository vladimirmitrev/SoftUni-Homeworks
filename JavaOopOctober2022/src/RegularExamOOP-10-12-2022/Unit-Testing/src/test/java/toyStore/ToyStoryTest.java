package toyStore;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ToyStoryTest {

    private ToyStore toyStore;
    private Toy toy1;
    private Toy toy2;
    private Toy toy3;

    @Before
    public void setUp() {
        toyStore = new ToyStore();
        toy1 = new Toy("Lego", "111");
        toy2 = new Toy("Roko", "222");
        toy3 = new Toy("Kiko", "333");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetToyShelf_ThrowsForUnmodifiable() {
        toyStore.getToyShelf().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToy_ThrowsForNoExistingShelf() throws OperationNotSupportedException {
        toyStore.addToy("shelf1", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToy_ThrowsForAlreadyTakenShelf() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToy_ThrowsForAlreadyToyOnShelf() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy1);
    }

    @Test
    public void testAddToy_Success() throws OperationNotSupportedException {
        String expected = "Toy:111 placed successfully!";
        String actual = toyStore.addToy("A", toy1);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveToy_Success() throws OperationNotSupportedException {
        String expected = "Remove toy:111 successfully!";
        toyStore.addToy("A", toy1);
        String actual = toyStore.removeToy("A", toy1);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToy_ThrowsForNotExistingShelf() throws OperationNotSupportedException {
        toyStore.removeToy("shelf", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToy_ThrowsForNotExistingToy() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.removeToy("A", toy2);
    }
    @Test
    public void testRemoveToy_ShouldSetShelfToNull() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.removeToy("A", toy1);
        Toy emptyShelf = toyStore.getToyShelf().get("A");
        assertNull(emptyShelf);
    }
}