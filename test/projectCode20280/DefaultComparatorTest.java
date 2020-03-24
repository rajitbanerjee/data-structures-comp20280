package projectCode20280;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultComparatorTest {
    @Test
    void testCompare() {
        DefaultComparator<Integer> comp = new DefaultComparator<>();
        assertTrue(comp.compare(20, 10) > 0);
        assertTrue(comp.compare(10, 20) < 0);
        assertEquals(0, comp.compare(10, 10));
    }

}