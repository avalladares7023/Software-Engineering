import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {
    Cup cup;

    @BeforeEach
    public void setUp() {
        cup = new Cup("water", 75.0);
    }

    @Test
    void testObjectCreation () {
        // Cup cup = new Cup("water", 75.0);
        assertEquals("water", cup.getLiquidType());
        assertEquals(75.0, cup.getPercentFull(), 0.001);
    }

    @Test
    void testIsEmpty() {
        // Cup cup = new Cup("water", 75.0);
        assertFalse(cup.isEmpty());
    }

    @Test
    void testSetLiquidwithNull() {
        // Cup cup = new Cup("water", 0.75);
        cup.setLiquidType(null);
        //assertEquals("water", cup.getLiquidType());
        assertNotNull(cup.getLiquidType());
    }

    @Disabled("Waiting on team to fix fault....")
    @Test
    void testExternalLib() {
        // Imagine depending on someone else' code
        // .....

        fail();
    }

    @Test
    void testSetBadPercent() {
        // Cup cup = new Cup("water", 0.75);
        assertThrows(IllegalArgumentException.class,
                () -> cup.setPercentFull(-1)
        );
    }
}