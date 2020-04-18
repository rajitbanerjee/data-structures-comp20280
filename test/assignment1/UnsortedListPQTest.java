package assignment1;

import interfaces.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Assignment 1, Question 5
 * Test for an implementation of PriorityQueue using
 * an unsorted list.
 *
 * @author Rajit Banerjee, 18202817
 */

class UnsortedListPQTest {
    private UnsortedListPQ<Integer, Integer> pq;

    @BeforeEach
    void setUp() {
        pq = new UnsortedListPQ<>();
    }

    @Test
    void testIsEmpty() {
        assertTrue(pq.isEmpty());
        pq.insert(1, 1);
        pq.insert(2, 2);
        pq.insert(0, 0);
        assertFalse(pq.isEmpty());
    }

    @Test
    void testMin() {
        assertNull(pq.min());
        testInsert();
        pq.insert(0, 0);
        Entry<Integer, Integer> entry = pq.min();
        assertEquals("<0, 0>", entry.toString());
    }

    @Test
    void testInsert() {
        pq.insert(1, 1);
        pq.insert(2, 2);
        pq.insert(3, 3);
        pq.insert(0, 0);
        assertEquals("[1, 2, 3, 0]", pq.toString());
    }

    @Test
    void testRemoveMin() {
        assertNull(pq.removeMin());
        testInsert();
        assertEquals("[1, 2, 3, 0]", pq.toString());
        Entry<Integer, Integer> entry = pq.removeMin();
        assertEquals("<0, 0>", entry.toString());
        assertEquals("[1, 2, 3]", pq.toString());
    }

}