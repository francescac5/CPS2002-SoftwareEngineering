import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PositionTest {
    @Test
    public void testSetX(){
        Position p = new Position();
        p.setX(2);
        assertTrue(p.getX() == 2);
    }

    @Test
    public void testSetY(){
        Position p = new Position();
        p.setY(3);
        assertTrue(p.getY() == 3);
    }

}
