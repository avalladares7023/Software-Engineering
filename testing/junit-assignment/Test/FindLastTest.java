import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindLastTest {
    // test: x = [2, 3, 5]; y = 2; Expected = 0
    @Test
    public void testIndexComparison()
    {
        FindLast tester = new FindLast();
        int[] x = {2, 3, 5};
        int y = 2;
        // A print statement if assert fails
        assertTrue(0 == tester.findLast(x, y),
                "The last index is incorrect"); // Expected: true, Actual: false
        assertEquals(0, tester.findLast(x, y)); // Expected: 0, Actual: -1
    }

    // Test for the NullPointerException
    @Test
    public void testForNullValue() {
        FindLast tester = new FindLast();
        int[] x = null;
        int y = 3;

        /* Expected the NullPointerException will be thrown, Actually nothing is thrown*/
        assertThrows(NullPointerException.class,
                () -> FindLast.findLast(x, y)
        );
    }

    // Test for fault that does not result in failure
    @Test
    public void testForFault() {
        FindLast tester = new FindLast();
        int[] x = {2, 3, 5};
        int y = 3;

        assertEquals(1, tester.findLast(x, y));
    }

    // Test for value that does not match any of the array values
    @Test
    public void testForInvalidElement() {
        FindLast tester = new FindLast();
        int[] x = {2, 3, 5};
        int y = 7;
        // a print statement if assert fails
        assertTrue(-1 == tester.findLast(x, y),
                "The y value does exist in the x array");
    }
}