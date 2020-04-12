package Part1;

import org.junit.*;

import java.io.File;

import static org.junit.Assert.*;

public class MapTests {

    public Map map;

    @Before
    public void setup() {
        map = new Map();

        //reset map count to zero
        map.initMapCount();
    }

    @After
    public void tearDown() {

        map = null;
    }
//********** map.initMapCount() tests *******\\

    @Test
    public void testInitMapCount(){
        //Exercise
        map.initMapCount();

        //Assert
        assertEquals(0, map.getMapCount());
    }

//********** map.setMapSize() tests **********\\

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

//********** map.generate() tests **********\\
    @Test
    public void testGenerate() {
        //Exercise
        //generates map0.html file
        map.generate();

        File map0 = new File("src\\GameMaps\\map0.html");

        //Assert
        assertTrue(map0.exists());
        assertEquals(1, map.getMapCount());

        //deleting generated map
        assertTrue(map0.delete());
    }

    @Test
    public void testGenerateTwoMaps_MinPlayers() {
        //Exercise
        //generates map0.html file
        map.generate();

        File map0 = new File("src\\GameMaps\\map0.html");

        //Assert
        assertTrue(map0.exists());
        assertEquals(1, map.getMapCount());

        //generates map1.html file
        map.generate();

        File map1 = new File("src\\GameMaps\\map1.html");

        //Assert map0.html and map1.html exist
        assertTrue(map0.exists());
        assertTrue(map1.exists());
        assertEquals(2, map.getMapCount());

        //deleting generated maps
        assertTrue(map0.delete());
        assertTrue(map1.delete());
    }

    @Test
    public void testGenerateThreeMaps() {
        //Exercise
        //generates map0.html file
        map.generate();

        File map0 = new File("src\\GameMaps\\map0.html");

        //Assert
        assertTrue(map0.exists());
        assertEquals(1, map.getMapCount());

        //generates map1.html file
        map.generate();

        File map1 = new File("src\\GameMaps\\map1.html");

        //Assert map0.html and map1.html exist
        assertTrue(map0.exists());
        assertTrue(map1.exists());
        assertEquals(2, map.getMapCount());

        //generates map2.html file
        map.generate();

        File map2 = new File("src\\GameMaps\\map2.html");

        //Assert map0.html, map1.html and map2.html exist
        assertTrue(map0.exists());
        assertTrue(map1.exists());
        assertTrue(map2.exists());
        assertEquals(3, map.getMapCount());

        //deleting generated maps
        assertTrue(map0.delete());
        assertTrue(map1.delete());
        assertTrue(map2.delete());
    }

    @Test
    public void testGenerateEightMaps_MaxPlayers() {
        //Exercise
        //generates map0.html file
        map.generate();

        File map0 = new File("src\\GameMaps\\map0.html");

        //Assert
        assertTrue(map0.exists());
        assertEquals(1, map.getMapCount());

        //generates map1.html file
        map.generate();

        File map1 = new File("src\\GameMaps\\map1.html");

        //Assert map0.html and map1.html exist
        assertTrue(map0.exists());
        assertTrue(map1.exists());
        assertEquals(2, map.getMapCount());

        //generates map2.html file
        map.generate();

        File map2 = new File("src\\GameMaps\\map2.html");

        //Assert map0.html, map1.html and map2.html exist
        assertTrue(map0.exists());
        assertTrue(map1.exists());
        assertTrue(map2.exists());
        assertEquals(3, map.getMapCount());

        //generates map3.html file
        map.generate();

        File map3 = new File("src\\GameMaps\\map3.html");

        //Assert map0.html, map1.html, map2.html and map3.html exist
        assertTrue(map0.exists());
        assertTrue(map1.exists());
        assertTrue(map2.exists());
        assertTrue(map3.exists());
        assertEquals(4, map.getMapCount());

        //generates map4.html file
        map.generate();

        File map4 = new File("src\\GameMaps\\map4.html");

        //Assert map0.html, map1.html map2.html, map3.html and map4.html exist
        assertTrue(map0.exists());
        assertTrue(map1.exists());
        assertTrue(map2.exists());
        assertTrue(map3.exists());
        assertTrue(map4.exists());
        assertEquals(5, map.getMapCount());

        //generates map5.html file
        map.generate();

        File map5 = new File("src\\GameMaps\\map5.html");

        //Assert map0.html, map1.html map2.html, map3.html, map4.html and map5.html exist
        assertTrue(map0.exists());
        assertTrue(map1.exists());
        assertTrue(map2.exists());
        assertTrue(map3.exists());
        assertTrue(map4.exists());
        assertTrue(map5.exists());
        assertEquals(6, map.getMapCount());

        //generates map6.html file
        map.generate();

        File map6 = new File("src\\GameMaps\\map6.html");

        //Assert map0.html, map1.html map2.html, map3.html, map4.html, map5.html and map6.html exist
        assertTrue(map0.exists());
        assertTrue(map1.exists());
        assertTrue(map2.exists());
        assertTrue(map3.exists());
        assertTrue(map4.exists());
        assertTrue(map5.exists());
        assertTrue(map6.exists());
        assertEquals(7, map.getMapCount());

        //generates map7.html file
        map.generate();

        File map7 = new File("src\\GameMaps\\map7.html");

        //Assert map0.html, map1.html map2.html, map3.html, map4.html, map5.html, map6.html and map7.html exist
        assertTrue(map0.exists());
        assertTrue(map1.exists());
        assertTrue(map2.exists());
        assertTrue(map3.exists());
        assertTrue(map4.exists());
        assertTrue(map5.exists());
        assertTrue(map6.exists());
        assertTrue(map7.exists());
        assertEquals(8, map.getMapCount());

        //deleting generated maps
        assertTrue(map0.delete());
        assertTrue(map1.delete());
        assertTrue(map2.delete());
        assertTrue(map3.delete());
        assertTrue(map4.delete());
        assertTrue(map5.delete());
        assertTrue(map6.delete());
        assertTrue(map7.delete());
    }
}
