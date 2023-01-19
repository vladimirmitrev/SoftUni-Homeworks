package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {1, 5, 7, 9, 11, 33};

    @Before
    public void prepare() throws OperationNotSupportedException {
        Integer[] numbers = NUMBERS;
        database = new Database(numbers);
    }

    @Test
    public void testCreateDatabase() throws OperationNotSupportedException {

        Integer[] dbElements = database.getElements();

        Assert.assertEquals(NUMBERS.length, dbElements.length);

        Assert.assertArrayEquals(NUMBERS, dbElements);

//        for (int i = 0; i < NUMBERS.length; i++) {
//            Assert.assertEquals(NUMBERS[i], dbElements[i]);
//        }

    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorWithLessThan1Element() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        new Database(emptyArray);
    }
    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] bigIntegerArray = new Integer[17];
        new Database(bigIntegerArray);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddWithNullArgumentShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void addASuccess() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.add(12);
        Integer[] dbElements = database.getElements();
        int lastDbElement = dbElements[dbElements.length - 1];

        Assert.assertEquals(12, lastDbElement);
        Assert.assertEquals(initialSize + 1, dbElements.length);
    }

    @Test
    public void removeSuccess() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.remove();
        Integer[] currentElements = database.getElements();

        Assert.assertEquals(initialSize - 1, currentElements.length);

        int secondToLastElementBeforeDelete = NUMBERS[NUMBERS.length - 2];
        int lastElementAfterDelete = currentElements[currentElements.length - 1];
        Assert.assertEquals(secondToLastElementBeforeDelete, lastElementAfterDelete);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testShouldForEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}