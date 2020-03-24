package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for recursion/Digits.java
 *
 * @author Rajit Banerjee, 18202817
 */
class DigitsTest {
    @Test
    void testSumDigits() {
        assertEquals(4, Digits.sum(121));
        assertEquals(15, Digits.sum(54321));
    }
}