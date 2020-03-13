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
    private static int MAX_SIZE = 1000; // default maximum stack size

    /**
     * Creates a new Stack bounded by the specified capacity.
     *
     * @param maxSize user defined Stack capacity
     */
    BoundedStack(int maxSize) {
        stack = new SinglyLinkedList<>();
        BoundedStack.MAX_SIZE = maxSize;
    }

    /**
     * By default, a stack is bounded by 1000 elements.
     */
    BoundedStack() {
        this(MAX_SIZE);
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
        if (size() == MAX_SIZE) {
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

    public static void main(String[] args) {
        BoundedStack<Integer> stk = new BoundedStack<>(10);
        for (int i = 1; i <= 10; i++) {
            stk.push(i);
        }
        System.out.println(stk);
        stk.pop();
        System.out.println(stk);
        stk.pop();
        stk.push(200);
        System.out.println(stk);
        stk.reverse();
        System.out.println("Reversed: " + stk);
        try {
            stk.push(200);
            stk.push(300);
            System.out.println("Error: Stack is bounded, overflow has occurred!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
