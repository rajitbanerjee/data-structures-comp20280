package projectCode20280;

/**
 * Implementation of an array based Stack.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class ArrayStack<E> implements Stack<E> {
    public static final int MAX_SIZE = 1000; //default array capacity
    private E[] stack;
    private int top;

    /**
     * Parameterised constructor for new array based stack.
     *
     * @param capacity maximum stack size set by user
     */
    @SuppressWarnings({"unchecked"})
    ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
        top = -1; // no initial stack members
    }

    /**
     * Construct array based stack with default maximum size.
     */
    ArrayStack() {
        this(MAX_SIZE);
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
     * @throws StackOverflowError if push operation is tried on a full Stack
     */
    @Override
    public void push(E e) throws StackOverflowError {
        if (size() == MAX_SIZE) {
            throw new StackOverflowError("Stack is full!");
        } else {
            stack[top++] = e;
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
     * @return the removed top element of Stack
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        } else {
            return stack[top--];
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
