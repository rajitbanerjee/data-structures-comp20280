package queues;

import lists.DoublyLinkedList;
import projectCode20280.Deque;

/**
 * Implementation of a linked list based Deque.
 * <p>
 * 1. Implements Deque ADT functions: size(), isEmpty(), first(), last(), addFirst(),
 * addLast(), removeFirst(), removeLast()
 * 2. Additional public method: toString()
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class LinkedDeque<E> implements Deque<E> {
    private DoublyLinkedList<E> deque = new DoublyLinkedList<>();

    /**
     * Returns the number of elements in the deque.
     *
     * @return number of elements in the deque
     */
    @Override
    public int size() {
        return deque.size();
    }

    /**
     * Tests whether the deque is empty.
     *
     * @return true if the deque is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    /**
     * Returns (but does not remove) the first element of the deque.
     *
     * @return first element of the deque (or null if empty)
     */
    @Override
    public E first() {
        return deque.first();
    }

    /**
     * Returns (but does not remove) the last element of the deque.
     *
     * @return last element of the deque (or null if empty)
     */
    @Override
    public E last() {
        return deque.last();
    }

    /**
     * Inserts an element at the front of the deque.
     *
     * @param e the new element
     */
    @Override
    public void addFirst(E e) {
        deque.addFirst(e);
    }

    /**
     * Inserts an element at the back of the deque.
     *
     * @param e the new element
     */
    @Override
    public void addLast(E e) {
        deque.addLast(e);
    }

    /**
     * Removes and returns the first element of the deque.
     *
     * @return element removed (or null if empty)
     */
    @Override
    public E removeFirst() {
        return deque.removeFirst();
    }

    /**
     * Removes and returns the last element of the deque.
     *
     * @return element removed (or null if empty)
     */
    @Override
    public E removeLast() {
        return deque.removeLast();
    }

    /**
     * Gets the String representation of the deque.
     *
     * @return String representation of the deque
     */
    public String toString() {
        return deque.toString();
    }

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedDeque<>();
        dq.addFirst(0);
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(-1);
        System.out.println("Initial deque: ");
        System.out.println(dq);

        System.out.println("First: " + dq.first());
        System.out.println("Last: " + dq.last());

        dq.removeFirst();
        System.out.println("After removeFirst(): ");
        System.out.println(dq);

        dq.removeLast();
        System.out.println("After removeLast(): ");
        System.out.println(dq);

        System.out.println("First: " + dq.first());
        System.out.println("Last: " + dq.last());
    }

}