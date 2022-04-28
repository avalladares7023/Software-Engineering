import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PredicateTest {
    private final PrintStream standardOut = System.out;
    private final PrintStream standardErr = System.err;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();

    // Here we are reassigning the standard output stream to a new PrintStream with ByteArrayOutputStream
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    // Here we restore the original state after each test
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setErr(standardErr);
    }

    // is the active clause
    @Test
    public void testTTT() {
        Predicate.test(true, true, true);
        assertEquals("Predicate is T", out.toString().trim());
    }

    // is the active clause
    @Test
    public void testTTF() {
        Predicate.test(true, true, false);
        assertEquals("Predicate is T", out.toString().trim());
    }

    // is the active clause
    @Test
    public void testTFT() {
        Predicate.test(true, false, true);
        assertEquals("Predicate is T", out.toString().trim());
    }

    // is the active clause
    @Test
    public void testTFF() {
        Predicate.test(true, false, false);
        assertEquals("Predicate is F", out.toString().trim());
    }

    // is the active clause
    @Test
    public void testFTT() {
        Predicate.test(false, true, true);
        assertEquals("Predicate is F", out.toString().trim());
    }

    // is the active clause
    @Test
    public void testFTF() {
        Predicate.test(false, true, false);
        assertEquals("Predicate is F", out.toString().trim());
    }

    // is the active clause
    @Test
    public void testFFT() {
        Predicate.test(false, false, true);
        assertEquals("Predicate is F", out.toString().trim());
    }

    // is the active clause
    @Test
    public void testFFF() {
        Predicate.test(false, false, false);
        assertEquals("Predicate is F", out.toString().trim());
    }
}