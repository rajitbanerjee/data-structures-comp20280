package queues;

import projectCode20280.Queue;
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

    /**
     * Move all elements from the enqueue stack to dequeue stack
     */
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
        if (isEmpty()) return "[]";
        return "Enqueue stack: " + enqueueStack.toString() +
                "\nDequeue stack: " + dequeueStack.toString() + "\n";
    }

}
