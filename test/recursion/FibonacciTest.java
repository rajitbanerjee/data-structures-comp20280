package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Tests for recursion/Fibonacci.java
 *
 * @author Rajit Banerjee, 18202817
 */
class FibonacciTest {
    @Test
    void testFibonacci() {
        try {
            Fibonacci.number(0);
            Fibonacci.number(-1);
            fail("Invalid input!");
        } catch (Exception ignored) {
            // Test passed
        }
        assertEquals(0, Fibonacci.number(1));
        assertEquals(1, Fibonacci.number(2));
        assertEquals(1, Fibonacci.number(3));
        assertEquals(2, Fibonacci.number(4));
        assertEquals(3, Fibonacci.number(5));
        assertEquals(5, Fibonacci.number(6));
        assertEquals(8, Fibonacci.number(7));
        assertEquals(13, Fibonacci.number(8));
    }

}