package trees;

import interfaces.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;

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
        assertTrue(heap.sanityCheck());
        assertEquals("[1, 2, 3, 5, 4]", heap.toString());
    }

    @Test
    void testMaxHeapConstructor() {
        heap = new HeapPriorityQueue<>((o1, o2) -> {
            // Negate the comparison to create max heap (max element at root)
            return -o1.compareTo(o2);
        });
        Random rnd = new Random();
        int n = 32;
        java.util.List<Integer> rands = rnd.ints(1, 1000).
                limit(n).distinct().boxed().collect(Collectors.toList());
        for (Integer i : rands) {
            heap.insert(i, i);
            // Max heap should also satisfy heap invariant
            assertTrue(heap.sanityCheck());
        }
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
        testBottomUpConstructor(); // Insert elements
        heap.insert(0, 0);
        Entry<Integer, Integer> entry = heap.min();
        assertEquals("<0, 0>", entry.toString());
    }

    @Test
    void testInsert() {
        Random rnd = new Random();
        int n = 32;
        java.util.List<Integer> rands = rnd.ints(1, 1000).
                limit(n).distinct().boxed().collect(Collectors.toList());
        for (Integer i : rands) {
            heap.insert(i, i);
            // Heap invariant should be satisfied after insert
            assertTrue(heap.sanityCheck());
        }
    }

    @Test
    void testRemoveMin() {
        testInsert(); // Insert elements
        while (!heap.isEmpty()) {
            heap.removeMin();
            assertTrue(heap.sanityCheck());
        }
    }

}