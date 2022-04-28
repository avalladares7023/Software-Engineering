import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTypeTest {
    public int x;
    public int y;
    public int z;
    public Triangle t;

    public TriangleTypeTest (int x, int y, int z, Triangle t) {
        this.x = x; this.y = y; this.z = z; this.t = t;
    }

    @Parameters public static Collection<Object[]> parameters() {

        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {});
        list.add(new Object[] {1, 2, 0, Triangle.INVALID});
        list.add(new Object[] {0, 1, 2, Triangle.INVALID});
        list.add(new Object[] {1, 0, 2, Triangle.INVALID});
        list.add(new Object[] {1, 2, 3, Triangle.INVALID});
        list.add(new Object[] {1, 3, 2, Triangle.INVALID});
        list.add(new Object[] {3, 1, 2, Triangle.INVALID});
        list.add(new Object[] {2, 2, 4, Triangle.INVALID});
        list.add(new Object[] {2, 4, 2, Triangle.INVALID});
        list.add(new Object[] {4, 2, 2, Triangle.INVALID});
        list.add(new Object[] {2, 2, 3, Triangle.ISOSCELES});
        list.add(new Object[] {3, 2, 2, Triangle.ISOSCELES});
        list.add(new Object[] {2, 3, 2, Triangle.ISOSCELES});
        list.add(new Object[] {2, 2, 2, Triangle.EQUILATERAL});
        list.add(new Object[] {2, 3, 4, Triangle.SCALENE});
        list.add(new Object[] {4, 3, 2, Triangle.SCALENE});
        list.add(new Object[] {3, 4, 2, Triangle.SCALENE});

        return list;
    }

    @Test
    public void triangleTest() {
        assertEquals(TriangleType.triangle(x, y, z), t);
    }
}