import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PositionTest {
    @Test
    public void testSetX(){
        Position p = new Position(3,4);
        assertEquals(3, Position.getX());
    }

    @Test
    public void testSetY(){
        Position p = new Position(3,4);
        assertEquals(4, Position.getY());
    }

}
