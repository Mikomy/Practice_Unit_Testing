import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testSum() {
        int expected = 3;
        int actual = calculator.sum(1,2);

        assertEquals(expected, actual);
    }

    @Test
    void subtract() {
        int expected = -2;
        int actual = calculator.subtract(1,3);
        assertEquals(expected,actual);
    }

    @Test
    void multiply() {
        int expected = 3;
        int actual = calculator.multiply(1,3);
        assertEquals(expected,actual);
    }

    @Test
    void divide() {
        int expected = 3;
        int actual = calculator.divide(9,3);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, -2, -100000, 200000})
    public void testIsEven(int number) {
    boolean actual = calculator.isEven(number);
    assertTrue(actual);
    }

    @Test
    public void testIsOdd() {
        boolean actual = calculator.isEven(1);
        assertFalse(actual);
    }

    @Test
    public void testIncrementArray() {
        int[] expected = new int[]{2,3,4};
        int [] actual = calculator.incrementArray(new int[]{1,2,3});

        assertArrayEquals(actual, expected);
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(1,0) );

        String expected = "Ints cannot be divided by zero";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }
}
