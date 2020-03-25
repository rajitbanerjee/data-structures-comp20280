package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for recursion/Collatz.java
 *
 * @author Rajit Banerjee, 18202817
 */
class CollatzTest {
    @Test
    void testCollatz() {
        assertEquals(1, Collatz.sequence(5));
        assertEquals(1, Collatz.sequence(9));
        assertEquals(1, Collatz.sequence(871));
        // Check integers till 2^16
        // Recursion call stack overflows with 2^17
        for (int i = 1; i <= (int) (Math.pow(2, 16)); i++) {
            assertEquals(1, Collatz.sequence(i));
        }
    }

}