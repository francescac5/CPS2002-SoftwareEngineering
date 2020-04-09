package Part1;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTests {
    public Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAddWithTwoPositiveNumbers() {
        //Exercise
        int result = calculator.add(5,2);

        //Assert
        assertEquals(7, result);
    }

    @Test
    public void testAddWithTwoNegativeNumbers() {
        //Exercise
        int result = calculator.add(-5,-2);

        //Assert
        assertEquals(-7, result);
    }

    @Test
    public void testAddWithANegativeAndPositiveNumber() {
        //Exercise
        int result = calculator.add(5,-2);

        //Assert
        assertEquals(3, result);
    }

}
