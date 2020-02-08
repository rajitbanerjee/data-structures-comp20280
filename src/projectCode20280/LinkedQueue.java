package projectCode20280;

/**
 * Implementation of a linked list based Queue.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class LinkedQueue<E> implements Queue<E> {
    private DoublyLinkedList<E> queue = new DoublyLinkedList<>();

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        queue.addLast(e);
    }

    @Override
    public E first() {
        return queue.get(0);
    }

    @Override
    public E dequeue() {
        return queue.removeFirst();
    }

	@Override
	public String toString() {
		return queue.toString();
	}

	public static void main(String[] args) {
        LinkedQueue<Integer> q = new LinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        q.enqueue(10);
        System.out.println(q);
        q.enqueue(11);
        System.out.println(q);
        q.enqueue(12);
        System.out.println(q);
    }

}