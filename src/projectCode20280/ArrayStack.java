package projectCode20280;

/**
 * Implementation of an array based Stack.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class ArrayStack<E> implements Stack<E> {
    private static int CAPACITY = 1000; //default array capacity
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
        ArrayStack.CAPACITY = capacity; // change the default stack capacity
    }

    /**
     * Construct array based stack with default maximum size.
     */
    ArrayStack() {
        this(CAPACITY);
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
        if (size() == CAPACITY) {
            throw new StackOverflowError("Stack is full!");
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

    /**
     * Gets String representation of Stack.
     *
     * @return String representation of Stack
     */
    @Override
    public String toString() {
        if (isEmpty()) return null;
        StringBuilder ans = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            ans.append(stack[i]).append(", ");
        }
        ans = new StringBuilder(ans.substring(0, ans.length() - 2));
        ans.append("]");
        return ans.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stk = new ArrayStack<>();
        for (int i = 1; i <= 10; i++) {
            stk.push(i);
        }
        System.out.println(stk);
        stk.pop();
        System.out.println(stk);
        stk.pop();
        stk.push(200);
        System.out.println(stk);
    }

}