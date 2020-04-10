package queues;

import lists.CircularlyLinkedList;
import projectCode20280.Queue;

/**
 * Realization of a circular FIFO queue as an adaptation of a
 * CircularlyLinkedList. This provides one additional method not part of the
 * general Queue interface. A call to rotate() is a more efficient simulation of
 * the combination enqueue(dequeue()). All operations are performed in constant
 * time.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */
public class LinkedCircularQueue<E> implements Queue<E> {
    private CircularlyLinkedList<E> queue = new CircularlyLinkedList<>();

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        LinkedCircularQueue<Integer> queue = new LinkedCircularQueue<>();
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

        queue.rotate();
        System.out.println("\nAfter rotate(): ");
        System.out.println(queue);

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
     * Rotate the first element to the back of the list.
     * More efficient to use CircularlyLinkedList instead of the
     * operation enqueue(dequeue()).
     */
    public void rotate() {
        queue.rotate();
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