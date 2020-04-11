package Part1;

import org.junit.*;

import java.io.File;

import static org.junit.Assert.*;

public class MapTests {

    public Map map;

    @Before
    public void setup() {
        map = new Map();
    }

    @After
    public void tearDown() {
        map = null;
    }

    @Test
    public void testSetMapSize_GreaterThanMinSize() {
        //Exercise
        int size = 8;
        boolean result = map.setMapSize(size);

        //Assert
        assertTrue(result);
    }

    @Test
    public void testSetMapSize_MinSize() {
        //Exercise
        int size = 5;
        boolean result = map.setMapSize(size);

        //Assert
        assertTrue(result);
    }

    @Test
    public void testSetMapSize_LessThanMinSize() {
        //Exercise
        int size = 2;
        boolean result = map.setMapSize(size);

        //Assert
        assertFalse(result);
    }

    @Test
    public void testSetMapSize_NegativeSize() {
        //Exercise
        int size = -9;
        boolean result = map.setMapSize(size);

        //Assert
        assertFalse(result);
    }

    @Test
    public void testSetMapSize_ZeroSize() {
        //Exercise
        int size = 0;
        boolean result = map.setMapSize(size);

        //Assert
        assertFalse(result);
    }

    @Test
    public void testGenerate() {
        //Exercise
        //generates map0.html file
        map.generate();

        File map0 = new File("CPS2002-SoftwareEngineering\\src\\main\\resources\\map0.html");

        //Assert
        assertTrue(map0.exists());
    }

}
