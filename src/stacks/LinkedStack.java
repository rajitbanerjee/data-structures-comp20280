package stacks;

import lists.SinglyLinkedList;
import projectCode20280.Stack;

/**
 * Implementation of a linked list based Stack.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */
public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> stack = new SinglyLinkedList<>();

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