package assignment1;

import lists.DoublyLinkedList;
import projectCode20280.PriorityQueue;
import trees.HeapPriorityQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Assignment 1, Question 5.
 * Implement sorting using a priority queue.
 *
 * @author Rajit Banerjee, 18202817
 */

public class PQSort {
    // Compare the performance of heap sort and PQ sort using unsorted list
    public static void main(String[] args) {
        int sizeOfList = 500;
        System.out.println("List Size\tHeap Sort\tPQ Sort");
        for (int i = 0; i < 20; i++) {
            List<Integer> randomInts = new Random().ints(0, Integer.MAX_VALUE).
                    limit(sizeOfList).boxed().collect(Collectors.toCollection(LinkedList::new));
            DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>(randomInts);
            DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>(randomInts);

            long heapSortTime = PQSort.sort(list1, new HeapPriorityQueue<>());
            long unsortedListPQSortTime = PQSort.sort(list2, new UnsortedListPQ<>());
            if (!PQSort.isSorted(list1)) {
                System.err.println("Heap Sort failed!");
                break;
            }
            if (!PQSort.isSorted(list2)) {
                System.err.println("PQ Sort failed!");
                break;
            }
            System.out.printf("%7d\t%12d\t%8d\n", sizeOfList, heapSortTime, unsortedListPQSortTime);
            sizeOfList *= 1.1;
        }
    }

    /**
     * General implementation of PQ sort.
     * Efficiency depends on how the PriorityQueue pq has been
     * implemented (e.g. using a heap vs using an unsorted list).
     *
     * @param list to be sorted
     * @param pq   PriorityQueue to be used for the PQSort
     * @return the time taken (in nanoseconds) to perform the sort
     */
    public static <E extends Comparable<E>> long sort(DoublyLinkedList<E> list,
                                                      PriorityQueue<E, ?> pq) {
        long startTime = System.nanoTime();
        while (!list.isEmpty()) {
            E element = list.remove(0);
            pq.insert(element, null);
        }
        while (!pq.isEmpty()) {
            E element = pq.removeMin().getKey();
            list.addLast(element);
        }
        return System.nanoTime() - startTime;
    }

    /**
     * Check if the given list is sorted.
     *
     * @param list to be checked
     * @param <E>  generic type of list items
     * @return {@code true} if the list is sorted
     */
    public static <E extends Comparable<E>> boolean isSorted(DoublyLinkedList<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == null || list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

}