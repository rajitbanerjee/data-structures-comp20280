package assignment1;

import lists.DoublyLinkedList;
import projectCode20280.PriorityQueue;

/**
 * Assignment 1, Question 5.
 * Implement sorting using a priority queue.
 *
 * @author Rajit Banerjee, 18202817
 */
public class PQSort {
    /**
     * General implementation of PQ sort.
     * Efficiency depends on how the PriorityQueue pq has been
     * implemented (e.g. using a heap vs using an unsorted list).
     *
     * @param list to be sorted
     * @param pq   PriorityQueue to be used for the PQSort
     */
    public static <E extends Comparable<E>> long sort(DoublyLinkedList<E> list,
                                                      PriorityQueue<E, E> pq) {
        long startTime = System.nanoTime();
        while (!list.isEmpty()) {
            E element = list.remove(0);
            pq.insert(element, element);
        }
        while (!pq.isEmpty()) {
            E element = pq.removeMin().getKey();
            list.addLast(element);
        }
        return System.nanoTime() - startTime;
    }

    public static <E extends Comparable<E>> boolean isSorted(DoublyLinkedList<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == null || list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

}