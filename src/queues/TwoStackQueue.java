package queues;

import interfaces.Queue;
import stacks.LinkedStack;

/**
 * Implementation of a Queue using two Stacks.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class TwoStackQueue<E> implements Queue<E> {
    LinkedStack<E> enqueueStack = new LinkedStack<>();
    LinkedStack<E> dequeueStack = new LinkedStack<>();

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        System.out.println("~ TwoStackQueue ~");
        TwoStackQueue<Integer> q = new TwoStackQueue<>();
        for (int i = 1; i < 6; i++) {
            q.enqueue(i);
        }
        System.out.println("After enqueue 1-5:");
        System.out.println(q);
        q.dequeue();
        System.out.println("After dequeue:");
        System.out.println(q);
        q.dequeue();
        System.out.println("After dequeue:");
        System.out.println(q);
        q.enqueue(6);
        System.out.println("After enqueue 6:");
        System.out.println(q);
        q.enqueue(7);
        System.out.println("After enqueue 7:");
        System.out.println(q);
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }

    /**
     * Tests whether the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Inserts an element at the rear of the queue.
     *
     * @param e the element to be inserted
     */
    @Override
    public void enqueue(E e) {
        enqueueStack.push(e);
    }

    // Move all elements from the enqueue stack to dequeue stack
    private void moveElements() {
        while (!enqueueStack.isEmpty()) {
            dequeueStack.push(enqueueStack.pop());
        }
    }

    /**
     * Returns, but does not remove, the first element of the queue.
     *
     * @return the first element of the queue (or null if empty)
     */
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        } else {
            if (dequeueStack.isEmpty()) {
                moveElements();
            }
            return dequeueStack.top();
        }
    }

    /**
     * Removes and returns the first element of the queue.
     *
     * @return element removed (or null if empty)
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            if (dequeueStack.isEmpty()) {
                moveElements();
            }
            return dequeueStack.pop();
        }
    }

    /**
     * Gets the String representation of the Queue
     *
     * @return the Queue as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        return "Enqueue stack: " + enqueueStack.toString() +
                "\nDequeue stack: " + dequeueStack.toString() + "\n";
    }

}