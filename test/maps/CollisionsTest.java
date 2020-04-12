package maps;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static maps.Collisions.collisions;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for Collisions.
 *
 * @author Rajit Banerjee, 18202817
 */

class CollisionsTest {
    @Test
    void testCollisions() throws FileNotFoundException {
        assertEquals(4, collisions("polynomial", 41));
        assertEquals(387, collisions("polynomial", 17));
        assertEquals(290, collisions("cyclic", 7));
        assertEquals(147, collisions("old_java", 0));
        assertEquals(6, collisions("", 0));
    }

}