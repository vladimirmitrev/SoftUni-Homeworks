import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private Instock instock;

    @Before
    public void setUp() {
        this.instock = new Instock();
    }

    @Test
    public void test_Count_Should_Be_Zero_When_Instock_Empty() {
        assertEquals(0, instock.getCount());
    }

    @Test
    public void test_Count_Should_Be_5_When_Instock_Have_5_Products() {
        int productsCount = 5;
        addProductToInstock(productsCount);
        assertEquals(productsCount, instock.getCount());
    }

    @Test
    public void test_Contains_Should_Be_True_Or_False_When_Product_Present_Or_Not() {
        Product product = addProductToInstock(5)[3];
        assertTrue(instock.contains(product));
        assertFalse(instock.contains(new Product("not_present", 1, 1)));
    }

    @Test
    public void test_FindReturns_The_Correct_Product() {
        Product expected = addProductToInstock(10)[4];
        Product actual = instock.find(4);
        assertNotNull(actual);
        assertEquals(expected.getLabel(), actual.getLabel());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void test_Find_Should_Throw_With_Negative_Index() {
        instock.find(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void test_Find_Should_Throw_With_Index_Greater_ThanLast() {
        addProductToInstock(2);
        instock.find(instock.getCount());
    }

    @Test
    public void test_Change_Quantity_Should_Update_The_Product() {
        Product product = new Product("test", 2, 10);
        instock.add(product);
        int expected = product.getQuantity() + 5;
        instock.changeQuantity(product.getLabel(), expected);
        assertEquals(expected, product.getQuantity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Change_Quantity_Throws_When_No_Product_With_That_Label() {
        instock.changeQuantity("john doe", 10);
    }

    @Test
    public void test_FindByLabel_Should_Return_The_Correct_Product() {
        Product expected = addProductToInstock(10)[3];
        Product actual = instock.findByLabel(expected.getLabel());
        assertNotNull(actual);
        assertEquals(expected.getLabel(), actual.getLabel());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_FindByLabel_Throws_When_No_Product_With_That_Label() {
        instock.findByLabel("john doe");
    }

    @Test
    public void test_findFirstMostExpensiveProducts_Should_Return_TheCorrectProducts() {
        int productsToTake = 10;

        List<Product> expected = Arrays.stream(addProductToInstock(20))
                .sorted(Comparator.comparing(Product::getPrice).reversed() )
                .limit(productsToTake)
                .collect(Collectors.toList());

        Iterable<Product> iterable = instock.findFirstMostExpensiveProducts(productsToTake);

        List<Product> actual = assertIterableNotNullAndConvertToList(iterable);

        assertEquals(expected, actual);

    }

    @Test (expected = IllegalArgumentException.class)
    public void test_findFirstMostExpensiveProducts_Should_Throw_When_There_Are_LessProducts() {
        addProductToInstock(10);
        instock.findFirstMostExpensiveProducts(11);
    }

//    @Test
//    public void testFindFirstByAlphabeticalOrder_ReturnProductsSortedByLabel() {
//        Arrays.stream(addProductToInstock(10))
//                .filter
//
//
//    }




    private List<Product> assertIterableNotNullAndConvertToList(Iterable<Product> iterable) {
        assertNotNull(iterable);

        List<Product> products = new ArrayList<>();

        iterable.forEach(products::add);

        return products;
    }




    private Product[] addProductToInstock(int count) {

        Product[] arr = new Product[count];

        for (int i = 1; i <= count ; i++) {
            Product product = new Product("Product_" + i, 10.00 + i, i);
            instock.add(product);
            arr[i - 1] = product;
        }

        return arr;
    }
}