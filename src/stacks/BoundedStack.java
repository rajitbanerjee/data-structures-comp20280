package stacks;

import lists.SinglyLinkedList;
import projectCode20280.Stack;

/**
 * Implementation of a linked list based Bounded Stack.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */
public class BoundedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> stack;
    private int capacity;

    /**
     * Creates a new Stack bounded by the specified capacity.
     *
     * @param capacity user defined Stack capacity
     */
    BoundedStack(int capacity) {
        stack = new SinglyLinkedList<>();
        this.capacity = capacity;
    }

    /**
     * By default, a stack is bounded by 1000 elements.
     */
    BoundedStack() {
        this(1000);
    }

    /**
     * Gets the current number of Stack elements.
     *
     * @return the current size of the Stack
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * Check if the Stack is empty.
     *
     * @return {@code true} if Stack has 0 elements, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Insert an element at the top of Stack.
     *
     * @param e the element to be inserted
     * @throws IllegalStateException if stack capacity is exceeded
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == capacity) {
            throw new IllegalStateException("Stack is full!");
        } else {
            stack.addFirst(e);
        }
    }

    /**
     * Find the top element of the Stack.
     *
     * @return the top Stack element
     */
    @Override
    public E top() {
        return stack.get(0);
    }

    /**
     * Removes the element from the top of the Stack.
     *
     * @return the removed element
     */
    @Override
    public E pop() {
        return stack.removeFirst();
    }

    /**
     * Gets the String representation of the Stack
     *
     * @return String representation of Stack
     */
    @Override
    public String toString() {
        return stack.toString();
    }

    /**
     * Reverses order of Stack elements.
     */
    public void reverse() {
        stack.reverse();
    }

}