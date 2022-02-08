import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JunitDemoTest {
    @Test
    void getNameTest() {
        JunitDemo R = new JunitDemo("Poly");
        assertEquals( "Poly", R.getName());
    }

    @Test
    void isHappyTest() {
        JunitDemo R = new JunitDemo( "Poly");
        assertFalse(R.isHappy());
    }

    @Test
    void playTest() {
        JunitDemo R = new JunitDemo( "Poly");
        R.play();
        assertTrue(R.isHappy());
    }
}