package queues;

import interfaces.Queue;
import lists.DoublyLinkedList;

/**
 * Implementation of a linked list based Queue.
 * <p>
 * 1. Implements Queue ADT functions: size(), isEmpty(), enqueue(E e), first(), dequeue()
 * <p>
 * 2. Additional public method: toString()
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class LinkedQueue<E> implements Queue<E> {
    // implement a LinkedQueue using DLL as base
    private final DoublyLinkedList<E> queue = new DoublyLinkedList<>();

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        System.out.println("~ LinkedQueue ~");
        Queue<Integer> queue = new LinkedQueue<>();
        System.out.println("Initially: Queue is " + queue + ", size() = " +
                queue.size() + ", isEmpty() = " + queue.isEmpty());

        queue.enqueue(10);
        System.out.println("\nAfter enqueue:");
        System.out.println(queue);

        queue.enqueue(20);
        System.out.println("\nAfter enqueue:");
        System.out.println(queue);

        queue.enqueue(30);
        System.out.println("\nAfter enqueue:");
        System.out.println(queue);

        System.out.println("\nFirst: " + queue.first());
        System.out.println("Queue is empty = " + queue.isEmpty());

        System.out.println("\nDequeue element: " + queue.dequeue());
        System.out.println("After dequeue:");
        System.out.println(queue);

        System.out.println("\nDequeue element: " + queue.dequeue());
        System.out.println("After dequeue:");
        System.out.println(queue);
    }

    /**
     * Finds number of Queue elements.
     *
     * @return current size of the Queue
     */
    @Override
    public int size() {
        return queue.size();
    }

    /**
     * Checks if Queue is empty.
     *
     * @return {@code true} if Queue is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Insert element to the rear of the Queue.
     *
     * @param e the element to be inserted
     */
    @Override
    public void enqueue(E e) {
        queue.addLast(e);
    }

    /**
     * Peek (not remove) the front Queue element.
     *
     * @return element at the front of the Queue
     */
    @Override
    public E first() {
        return queue.get(0);
    }

    /**
     * Remove an element from the front of the Queue.
     *
     * @return the removed front Queue element
     */
    @Override
    public E dequeue() {
        return queue.removeFirst();
    }

    /**
     * Gets the String representation of the Queue
     *
     * @return the Queue as a String
     */
    @Override
    public String toString() {
        return queue.toString();
    }

}