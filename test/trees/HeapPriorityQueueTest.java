package trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCode20280.Entry;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for HeapPriorityQueue.
 *
 * @author Rajit Banerjee, 18202817
 */
class HeapPriorityQueueTest {
    private HeapPriorityQueue<Integer, Integer> heap;

    @BeforeEach
    void setUp() {
        heap = new HeapPriorityQueue<>();
    }

    @Test
    void testBottomUpConstructor() {
        Integer[] keys = {5, 4, 3, 2, 1};
        Integer[] values = {5, 4, 3, 2, 1};
        heap = new HeapPriorityQueue<>(keys, values);
        assertEquals("[1, 2, 3, 5, 4]", heap.toString());
    }

    @Test
    void testMaxHeapConstructor() {
        heap = new HeapPriorityQueue<>((o1, o2) -> {
            // negate the comparison to create max heap (max element at root)
            return -o1.compareTo(o2);
        });
        heap.insert(1, 1);
        heap.insert(2, 2);
        heap.insert(3, 3);
        heap.insert(4, 4);
        assertEquals("[4, 3, 2, 1]", heap.toString());
    }

    @Test
    void testIsEmpty() {
        assertTrue(heap.isEmpty());
        heap.insert(1, 1);
        heap.insert(2, 2);
        heap.insert(0, 0);
        assertFalse(heap.isEmpty());
    }

    @Test
    void testMin() {
        assertNull(heap.min());
        testBottomUpConstructor();
        heap.insert(0, 0);
        Entry<Integer, Integer> entry = heap.min();
        assertEquals("(0, 0)", entry.toString());
    }

    @Test
    void testInsert() {
        heap.insert(1, 1);
        heap.insert(2, 2);
        heap.insert(3, 3);
        heap.insert(0, 0);
        assertEquals("[0, 1, 3, 2]", heap.toString());
        heap.insert(0, 0);
        assertEquals("[0, 0, 3, 2, 1]", heap.toString());
    }

    @Test
    void testRemoveMin() {
        assertNull(heap.removeMin());
        testBottomUpConstructor();
        heap.insert(0, 0);
        assertEquals("[0, 2, 1, 5, 4, 3]", heap.toString());
        Entry<Integer, Integer> entry = heap.removeMin();
        assertEquals("(0, 0)", entry.toString());
        assertEquals("[1, 2, 3, 5, 4]", heap.toString());
    }

}