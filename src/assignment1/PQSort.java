package assignment1;

import lists.SinglyLinkedList;
import projectCode20280.PriorityQueue;
import trees.UnsortedListPQ;

/**
 * Assignment 1, Question 5.
 * Implement sorting using a priority queue.
 *
 * @author Rajit Banerjee, 18202817
 */
public class PQSort<E> {
    public void sort(SinglyLinkedList<E> list) {
        PriorityQueue<E, E> pq = new UnsortedListPQ<>();
        while (!list.isEmpty()) {
            E element = list.removeFirst();
            pq.insert(element, element);
        }
        while (!pq.isEmpty()) {
            E element = pq.removeMin().getKey();
            list.addLast(element);
        }
    }
}
