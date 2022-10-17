import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    public void testNormalPoint() {
        Point p = new Point(116.0, 45.0, 30.822);
        assertEquals(116.0, p.getDegree());
        assertEquals(45.0, p.getMinute());
        assertEquals(30.822, p.getSecond());
        assertEquals(116.7587, p.toDecimal(), 0.001);
    }


    @Test
    public void testNormalPoint2() {
        Point p = new Point(40.0, 2.5, 2.0);
        assertEquals(40.0, p.getDegree());
        assertEquals(2.0, p.getMinute());
        assertEquals(32.0, p.getSecond(), 0.01);
    }

    @Test
    public void testNegativePoint() {
        Point p = new Point(-116.0, 45.0, 30.822);
        assertEquals(-116.0, p.getDegree());
        assertEquals(45.0, p.getMinute());
        assertEquals(30.822, p.getSecond());
//        assertEquals(116.7587, p.toDecimal(), 0.01);
    }
}
