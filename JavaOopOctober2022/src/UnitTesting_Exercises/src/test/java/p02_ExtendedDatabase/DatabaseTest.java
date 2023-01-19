package p02_ExtendedDatabase;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;

    @Before
    public void prepare() throws OperationNotSupportedException {
        Person person1 = new Person(1, "Pesho");
        Person person2 = new Person(2, "Vanko");
        database = new Database(person1, person2);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNullShouldThrow() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByUsernameSuccess() throws OperationNotSupportedException {
        Person person = database.findByUsername("Pesho");

        Assert.assertEquals("Pesho", person.getUsername());
        Assert.assertEquals(1, person.getId());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void findByUsernameMissingName() throws OperationNotSupportedException {
        database.findByUsername("Andrei");
    }

    @Test
    public void testFindByIdSuccess() throws OperationNotSupportedException {
        Person person = database.findById(2);

        Assert.assertEquals(2, person.getId());
        Assert.assertEquals("Vanko", person.getUsername());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByIdWithMissingId() throws OperationNotSupportedException {
        database.findById(200);
    }
}