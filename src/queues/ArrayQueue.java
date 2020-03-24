package queues;

import projectCode20280.Queue;

/**
 * Implementation of an array based Queue.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class ArrayQueue<E> implements Queue<E> {
    private int capacity;
    private E[] queue;
    private int front;
    private int size;

    /**
     * Parameterised constructor, modifies the default Queue capacity.
     *
     * @param capacity the new capacity used to create a Queue
     */
    @SuppressWarnings({"unchecked"})
    ArrayQueue(int capacity) {
        front = size = 0;
        queue = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * Constructs a Queue with default capacity 1000.
     */
    ArrayQueue() {
        this(1000);
    }

    /**
     * Returns the current number of elements in the Queue.
     *
     * @return number of elements in Queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if Queue is empty.
     *
     * @return {@code true} if Queue is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Inserts an element to the rear of Queue.
     *
     * @param e the element to be inserted
     * @throws IllegalStateException queue has reached capacity
     */
    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full!");
        } else {
            int rear = (front + size++) % capacity; //circular array wraps around
            queue[rear] = e;
        }
    }

    /**
     * Remove front element of Queue.
     *
     * @return the removed front element, null if empty
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            E removed = queue[front];
            queue[front] = null;
            front = (front + 1) % capacity; // front index wraps around
            size--;
            return removed;
        }
    }

    /**
     * Return (but not remove) the element at front of Queue.
     *
     * @return the front element of the Queue, null if empty
     */
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        } else {
            return queue[front];
        }
    }

    /**
     * Gets String representation of Queue.
     *
     * @return String representation of Queue
     */
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = front; i < front + size; i++) {
            sb.append(queue[i % capacity]).append(", ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();

    }

    /*
    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<>(10);
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
     */

}
