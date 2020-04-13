import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testPositionD(){
        Position p = new Position (4,5);
        Player.move('D');
        assertEquals(4, Position.getY());
    }

    @Test
    public void testPositionU(){
        Position p = new Position (4,5);
        Player.move('U');
        assertEquals(6, Position.getY());
    }

    @Test
    public void testPositionL(){
        Position p = new Position (4,5);
        Player.move('L');
        assertEquals(3, Position.getX());
    }

    @Test
    public void testPositionR(){
        Position p = new Position (4,5);
        Player.move('R');
        assertEquals(5, Position.getX());
    }

    @Test
    public void testPositionUNKNOWN1(){
        Position p = new Position (4,5);
        Player.move('P');
        assertEquals(5, Position.getY());
    }

    @Test
    public void testPositionUNKNOWN2(){
        Position p = new Position (4,5);
        Player.move('P');
        assertEquals(4, Position.getX());
    }
}
