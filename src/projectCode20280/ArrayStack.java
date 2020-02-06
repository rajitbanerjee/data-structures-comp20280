package projectCode20280;

/**
 * Implementation of an array based Stack.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class ArrayStack<E> implements Stack<E> {
    public static final int MAX_SIZE = 1000;
    private E stack[];
    private int top = -1;

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(E e) {
        // TODO Auto-generated method stub

    }

    @Override
    public E top() {
        return stack[top];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        } else {
            E value = stack[top];
            top--;
            return value;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
