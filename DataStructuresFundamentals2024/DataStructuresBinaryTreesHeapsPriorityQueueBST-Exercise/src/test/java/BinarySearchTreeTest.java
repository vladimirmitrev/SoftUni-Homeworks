import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;
    @Before
    public void beforeEach() {
        bst = new BinarySearchTree<>(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(6);
        bst.insert(1);
        bst.insert(17);
    }
    @Test
    public void testCreate() {
        assertEquals(Integer.valueOf(5), bst.getRoot().getValue());
    }

    @Test
    public void testInsert() {
        assertEquals(Integer.valueOf(3), bst.getRoot().getLeft().getValue());
        assertEquals(Integer.valueOf(7), bst.getRoot().getRight().getValue());
        assertEquals(Integer.valueOf(6), bst.getRoot().getRight().getLeft().getValue());
    }

    @Test
    public void testInEachOrder() {
        List<Integer> elements = new ArrayList<>();

        bst.eachInOrder(e -> elements.add(e));

        List<Integer> expected = new ArrayList<>(
                Arrays.asList(1, 3, 5, 6, 7, 17)
        );

        assertEquals(expected.size(), elements.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), elements.get(i));
        }
    }

    @Test
    public void testContainsTrue() {
        assertTrue(bst.contains(6));
    }

    @Test
    public void testContainsFalse() {
        assertFalse(bst.contains(66));
    }
}