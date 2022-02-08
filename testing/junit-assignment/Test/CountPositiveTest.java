import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPositiveTest {
    // test: x = [-4, 2, 0, 2]; Expected = 2
    @Test
    public void testPositiveCount() {
        CountPositive test = new CountPositive();
        int[] x = {-4, 2, 0, 2};
        // A print statement if assert fails
        assertTrue(2 == test.countPositive(x),
                "The number of positive occurrences is incorrect");
    }

    // Test case(s) that do not execute the fault
    @Test
    public void testForNullValue() {
        CountPositive test = new CountPositive();
        int[] x = null;
        /* A print statement if assert fails
        assertTrue(0 == test.countPositive(x),
                "The null value is not recognized");*/
        // This NullPointer Exception test uses the fail assertion
        try {
            test.countPositive(x);
        } catch (NullPointerException e){
            return;
        }

        /* Alternative method
        assertThrows(NullPointerException.class,
                () -> test.countPositive(x)
        );*/
    }
    @Test
    public void testForEmpty() {
        CountPositive test = new CountPositive();
        int[] x = {};
        // The count should be 0 since the x array is empty
        assertEquals(0, test.countPositive(x));
    }

    // Test case that does not result in failure despite error state
    @Test
    public void testNonZeroPositive() {
        CountPositive test = new CountPositive();
        int[] x = {4, 2, 2}; // Only positive numbers
        // A print statement if assert fails
        assertTrue(3 == test.countPositive(x),
                "The number of positive occurrences is incorrect");
    }
    @Test
    public void testNonZeroNegative() {
        CountPositive test = new CountPositive();
        int[] x = {-4, 2, 2}; // Include negative number as well
        // A print statement if assert fails
        assertTrue(2 == test.countPositive(x),
                "The number of positive occurrences is incorrect");
    }

    /* Test case that checks for the NullPointerException
    @Test
    public void testNullPointerException() {
        CountPositive test = new CountPositive();
        int[] x = {-4, 2, 0, 2};

        assertThrows();
    }*/
}