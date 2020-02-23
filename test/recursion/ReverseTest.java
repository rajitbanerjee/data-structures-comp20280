package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for recursion/Reverse.java
 *
 * @author Rajit Banerjee, 18202817
 */
class ReverseTest {
    @Test
    void testReverse() {
        Integer[] A = {1, 2, 3, 4, 5};
        Reverse.reverseArray(A, 0, A.length - 1);
        int temp = 5;
        for (int num : A) {
            assertEquals(temp, num);
            temp--;
        }
    }
}