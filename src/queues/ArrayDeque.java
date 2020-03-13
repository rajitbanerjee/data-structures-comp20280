package queues;

import projectCode20280.Deque;

/**
 * Implementation of an array based Deque.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class ArrayDeque<E> implements Deque<E> {
    private static int CAPACITY = 1000; //default array capacity
    private E[] deque;
    private int front;
    private int rear;
    private int size;

    /**
     * Parameterised constructor, modifies the default Deque capacity.
     *
     * @param capacity the new capacity used to create a Deque
     */
    @SuppressWarnings({"unchecked"})
    ArrayDeque(int capacity) {
        front = rear = size = 0;
        deque = (E[]) new Object[capacity];
        ArrayDeque.CAPACITY = capacity;
    }

    /**
     * Constructs a Queue with default capacity.
     */
    ArrayDeque() {
        this(CAPACITY);
    }

    /**
     * Returns the number of elements in the deque.
     *
     * @return number of elements in the deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Tests whether the deque is empty.
     *
     * @return true if the deque is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the deque.
     *
     * @return first element of the deque (or null if empty)
     */
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        } else {
            return deque[front];
        }
    }

    /**
     * Returns (but does not remove) the last element of the deque.
     *
     * @return last element of the deque (or null if empty)
     */
    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        } else {
            return deque[rear];
        }
    }

    /**
     * Inserts an element at the front of the deque.
     *
     * @param e the new element
     * @throws IllegalStateException if deque has reached capacity
     */
    @Override
    public void addFirst(E e) throws IllegalStateException {
        if (size == CAPACITY) {
            throw new IllegalStateException("Deque is full!");
        } else {
            front = Math.floorMod(rear - size++, CAPACITY); //circular array wraps around
            deque[front] = e;
        }
    }

    /**
     * Inserts an element at the back of the deque.
     *
     * @param e the new element
     * @throws IllegalStateException if deque has reached capacity
     */
    @Override
    public void addLast(E e) throws IllegalStateException {
        if (size == CAPACITY) {
            throw new IllegalStateException("Deque is full!");
        } else {
            rear = (front + size++) % CAPACITY; //circular array wraps around
            deque[rear] = e;
        }
    }

    /**
     * Removes and returns the first element of the deque.
     *
     * @return element removed (or null if empty)
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            E removed = deque[front];
            deque[front] = null;
            front = (front + 1) % CAPACITY; // front index wraps around
            size--;
            return removed;
        }
    }

    /**
     * Removes and returns the last element of the deque.
     *
     * @return element removed, null if empty
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            E removed = deque[rear];
            deque[rear] = null;
            rear = Math.floorMod(rear - 1, CAPACITY); // front index wraps around
            size--;
            return removed;
        }
    }

    /**
     * Gets String representation of Deque.
     *
     * @return String representation of Deque
     */
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder ans = new StringBuilder("[");
        for (int i = front; i < front + size; i++) {
            ans.append(deque[i % CAPACITY]).append(", ");
        }
        ans = new StringBuilder(ans.substring(0, ans.length() - 2));
        ans.append("]");
        return ans.toString();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(0);
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(-1);
        System.out.println(dq);

        dq.removeFirst();
        System.out.println(dq);

        dq.removeLast();
        System.out.println(dq);
    }

}
