import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    @Test
    public void testAdd()
    {
        // A print statement if asserts fails
        assertTrue(5 == Calc.add(2, 3),
                "Calc sum incorrect");
        // 5 = Expected output, (2,3) = Test values
    }
}