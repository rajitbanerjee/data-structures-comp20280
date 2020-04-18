package maps;

import interfaces.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for ChainHashMap.
 *
 * @author Rajit Banerjee, 18202817
 */

class ChainHashMapTest {
    @Test
    void testBasic() {
        Map<Integer, Character> map = new ChainHashMap<>();
        assertTrue(map.isEmpty());
        assertNull(map.put(5, 'A'));
        assertNull(map.put(7, 'B'));
        assertNull(map.put(2, 'C'));
        assertNull(map.put(8, 'D'));
        assertEquals('C', map.put(2, 'E'));
        assertEquals('B', map.get(7));
        assertNull(map.get(4));
        assertEquals('E', map.get(2));
        assertEquals(4, map.size());
        assertEquals('A', map.remove(5));
        assertEquals('E', map.remove(2));
        assertNull(map.get(2));
        assertNull(map.remove(2));
        assertFalse(map.isEmpty());
    }

}