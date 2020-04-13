import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class GameTest {



    @Test
    public void testchoosedirectionD(){
        Game.choosedirection("L");
        Position p = new Position (4,5);
        Player.move('D');
        assertEquals(4, Position.getY());
    }

}
