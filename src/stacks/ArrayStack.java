package stacks;

import projectCode20280.Stack;

/**
 * Implementation of an array based Stack.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */
public class ArrayStack<E> implements Stack<E> {
    private int capacity;
    private E[] stack;
    private int top;

    /**
     * Parameterised constructor for new array based stack.
     *
     * @param capacity maximum stack size set by user
     */
    @SuppressWarnings({"unchecked"})
    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
        top = -1; // no initial stack members
        this.capacity = capacity; // change the default stack capacity
    }

    /**
     * Construct array based stack with default maximum size 1000.
     */
    ArrayStack() {
        this(1000);
    }

    /**
     * Gets the current number of Stack elements.
     *
     * @return size of Stack
     */
    @Override
    public int size() {
        return top + 1;
    }

    /**
     * Checks if Stack is empty.
     *
     * @return {@code true} is Stack size is 0, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Insert an element at the top of Stack.
     *
     * @param e the element to be inserted
     * @throws IllegalStateException if push operation is tried on a full Stack
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == capacity) {
            throw new IllegalStateException("Stack is full!");
        } else {
            stack[++top] = e;
        }
    }

    /**
     * Peek (without removing) at the top element of Stack.
     *
     * @return top Stack element, null if empty
     */
    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        } else {
            return stack[top];
        }
    }

    /**
     * Removes the top element of Stack.
     *
     * @return the removed top element of Stack, null if empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        } else {
            return stack[top--];
        }
    }

    /**
     * Gets String representation of Stack.
     *
     * @return String representation of Stack
     */
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(stack[i]).append(", ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }

}