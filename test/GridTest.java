import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GridTest {
    @Test
    public void testGridDistance() {
        Location beijing = new Grid("OM89fu").getCoordinate();
        Location japan = new Grid("PM97lg").getCoordinate();

        assertEquals(1972.4844, Location.distance(beijing, japan), 0.1);
    }

    @Test
    public void testGrid2CoordinateNE() {
        Grid grid = new Grid("OM89ck");
        assertEquals(39.0, grid.getCoordinate().getLat().getDegree());
        assertEquals(25.0, grid.getCoordinate().getLat().getMinute());
        assertEquals(0.0, grid.getCoordinate().getLat().getSecond());
        assertEquals(116.0, grid.getCoordinate().getLon().getDegree());
        assertEquals(10.0, grid.getCoordinate().getLon().getMinute());
        assertEquals(0.0, grid.getCoordinate().getLon().getSecond());

        grid = new Grid("ON80fb");
        System.out.println(grid);
        assertEquals(40.0, grid.getCoordinate().getLat().getDegree());
        assertEquals(2.0, grid.getCoordinate().getLat().getMinute());
        assertEquals(25.0, grid.getCoordinate().getLat().getSecond());
        assertEquals(116.0, grid.getCoordinate().getLon().getDegree());
        assertEquals(25.0, grid.getCoordinate().getLon().getMinute());
        assertEquals(0.0, grid.getCoordinate().getLon().getSecond());
    }
}
