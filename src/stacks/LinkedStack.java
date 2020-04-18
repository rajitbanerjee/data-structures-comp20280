package stacks;

import interfaces.Stack;
import lists.SinglyLinkedList;

/**
 * Implementation of a linked list based Stack.
 * <p>
 * 1. Implements Stack ADT functions: size(), isEmpty(), push(E e), top(), pop()
 * <p>
 * 2. Additional public methods: reverse(), toString()
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class LinkedStack<E> implements Stack<E> {
    private final SinglyLinkedList<E> stack = new SinglyLinkedList<>();

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        LinkedStack<Integer> stk = new LinkedStack<>();
        System.out.println("Initially: Stack is " + stk + ", size() = " +
                stk.size() + ", isEmpty() = " + stk.isEmpty());

        stk.push(10);
        System.out.println("\nAfter push:");
        System.out.println(stk);

        stk.push(20);
        System.out.println("\nAfter push:");
        System.out.println(stk);

        stk.push(30);
        System.out.println("\nAfter push:");
        System.out.println(stk);

        System.out.println("\nTop: " + stk.top());
        System.out.println("Stack is empty = " + stk.isEmpty());

        stk.reverse();
        System.out.println("\nAfter reverse:");
        System.out.println(stk);

        System.out.println("\nTop: " + stk.top());
        System.out.println("Stack is empty = " + stk.isEmpty());

        System.out.println("\nPopped element: " + stk.pop());
        System.out.println("After pop:");
        System.out.println(stk);

        System.out.println("\nPopped element: " + stk.pop());
        System.out.println("After pop:");
        System.out.println(stk);
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
     */
    @Override
    public void push(E e) {
        stack.addFirst(e);
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
     * Reverses order of Stack elements, using two additional Stacks.
     */
    public void reverse() {
        LinkedStack<E> helper1 = new LinkedStack<>();
        LinkedStack<E> helper2 = new LinkedStack<>();
        int size = size();
        for (int i = 0; i < size; i++) {
            helper1.push(this.pop());
        }
        for (int i = 0; i < size; i++) {
            helper2.push(helper1.pop());
        }
        for (int i = 0; i < size; i++) {
            this.push(helper2.pop());
        }
    }

}