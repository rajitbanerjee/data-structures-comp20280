package assignment1;

import org.junit.jupiter.api.Test;
import trees.HeapPriorityQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Assignment 1, Question 5
 * Checking if PQ Sort and Heap Sort work.
 *
 * @author Rajit Banerjee, 18202817
 */

class PQSortTest {
    @Test
    void testSort() {
        int sizeOfList = 500;
        List<Integer> randomInts = new Random().ints(0, Integer.MAX_VALUE).
                limit(sizeOfList).boxed().collect(Collectors.toCollection(LinkedList::new));
        ArrayList<Integer> list1 = new ArrayList<>(randomInts);
        ArrayList<Integer> list2 = new ArrayList<>(randomInts);
        assertEquals(list1.toString(), list2.toString());

        long heapSortTime = PQSort.sort(list1, new HeapPriorityQueue<>());
        long unsortedListPQSortTime = PQSort.sort(list2, new UnsortedListPQ<>());
        assertTrue(PQSort.isSorted(list1));
        assertTrue(PQSort.isSorted(list2));
        assertTrue(heapSortTime < unsortedListPQSortTime);
    }

}