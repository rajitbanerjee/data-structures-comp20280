package projectCode20280;

/**
 * Implementation of a Queue using two Stacks.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class TwoStackQueue<E> implements Queue<E> {

    /**
     * Returns the number of elements in the queue.
     *
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Tests whether the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Inserts an element at the rear of the queue.
     *
     * @param e the element to be inserted
     */
    @Override
    public void enqueue(E e) {

    }

    /**
     * Returns, but does not remove, the first element of the queue.
     *
     * @return the first element of the queue (or null if empty)
     */
    @Override
    public E first() {
        return null;
    }

    /**
     * Removes and returns the first element of the queue.
     *
     * @return element removed (or null if empty)
     */
    @Override
    public E dequeue() {
        return null;
    }

    /**
     * Gets the String representation of the Queue
     *
     * @return the Queue as a String
     */
    @Override
    public String toString() {
        return null;
    }

    // main method to run basic tests
    public static void main(String[] args) {
        TwoStackQueue<Integer> q = new TwoStackQueue<>();
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
