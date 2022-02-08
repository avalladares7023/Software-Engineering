import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
//...ArrayList
//...List;

class MinTest {
    private List<String> list; // Test fixture
    // Set up - Called before every test method.
    @BeforeEach
    public void setUp()
    {
        list = new ArrayList<String>();
    }

    // Tear down - Called after every test method.
    @AfterEach
    public void tearDown()
    {
        list = null; // Redundant in this example
    }

    // This NullPointer Exception test uses the fail assertion
    @Test
    public void testForNullList()
    {
        list = null;
        try {
            Min.min (list);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    // This NullPointerException test decorates the @Test
    // annotation with the class of the exception
    @Test //(expected = NullPointerException.class())
    public void testForNullElement()
    {
        list.add(null);
        list.add("cat");
        assertThrows(NullPointerException.class,
                () -> Min.min(list)
        );
    }

    // This NullPointerException test catches an easily
    // overlooked special case
    @Test //(expected = NullPointerException.class())
    public void testForSoloNullElement()
    {
        // This test can seem redundant to the previous test but it is meant to test a boundary
        list.add(null);
        assertThrows(NullPointerException.class,
                () -> Min.min(list)
        );
    }

    @Test //(expected = ClassCastException.class)
    @ SuppressWarnings("unchecked") // Removes warnings for this specific test
    public void testMutuallyIncomparable()
    {
        List list = new ArrayList(); // This list takes any data type
        list.add("cat");
        list.add("dog");
        list.add(1);
        assertThrows(ClassCastException.class,
                () -> Min.min(list)
        );
    }

    // Special case: Testing for the empty list
    @Test //(expected = IllegalArgumentException.class)
    public void testEmptyList()
    {
        assertThrows(IllegalArgumentException.class,
                () -> Min.min(list)
        );
    }

    // A "Happy Path" test - Does exactly what it is supposed to do
    @Test
    public void testSingleElement()
    {
        list.add("cat");
        Object obj = Min.min(list);
        assertTrue(obj.equals("cat"), "Single Element List");
    }

    // A "Happy Path" test - Does exactly what it is supposed to do
    @Test
    public void testDoubleElement()
    {
        list.add("dog");
        list.add("cat");
        Object obj = Min.min(list); // <- Polymorphism
        assertTrue(obj.equals("cat"), "Double Element List");
    }
}