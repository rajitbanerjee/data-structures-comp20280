package projectCode20280;

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

    // implement a LinkedQueue using DLL as base
    private CircularlyLinkedList<E> queue = new CircularlyLinkedList<>();

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

    // main method to run basic tests
    public static void main(String[] args) {
        LinkedCircularQueue<Integer> q = new LinkedCircularQueue<>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        q.enqueue(10);
        System.out.println(q);
        q.enqueue(11);
        System.out.println(q);
        q.enqueue(12);
        System.out.println(q);
    }

}
