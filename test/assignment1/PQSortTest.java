package assignment1;

import lists.DoublyLinkedList;
import org.junit.jupiter.api.Test;
import trees.HeapPriorityQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PQSortTest {
    @Test
    void testSort() {
        int sizeOfList = 100;
        List<Integer> randomInts =
                new Random().ints(0, 1000).limit(sizeOfList).
                        boxed().collect(Collectors.toCollection(LinkedList::new));
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>(randomInts);
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>(randomInts);
        assertEquals(list1.toString(), list2.toString());


        long heapSortTime = PQSort.sort(list1, new HeapPriorityQueue<>());
        assertTrue(PQSort.isSorted(list1));
        System.out.println("HeapSort time: " + heapSortTime);

        long unsortedListPQSortTime = PQSort.sort(list2, new UnsortedListPQ<>());
        assertTrue(PQSort.isSorted(list2));
        System.out.println("PQSort time: " + unsortedListPQSortTime);

        assertTrue(heapSortTime < unsortedListPQSortTime);
    }

}
