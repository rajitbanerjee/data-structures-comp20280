package projectCode20280;

/**
 * Implementation of a linked list based Deque.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class LinkedDeque<E> implements Deque<E> {
    // Implement deque with dq as base
    private DoublyLinkedList<E> deque = new DoublyLinkedList<>();

	/**
	 * Returns the number of elements in the deque.
	 *
	 * @return number of elements in the deque
	 */
	@Override
	public int size() {
		return deque.size();
	}

	/**
	 * Tests whether the deque is empty.
	 *
	 * @return true if the deque is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	/**
	 * Returns (but does not remove) the first element of the deque.
	 *
	 * @return first element of the deque (or null if empty)
	 */
	@Override
	public E first() {
		return deque.first();
	}

	/**
	 * Returns (but does not remove) the last element of the deque.
	 *
	 * @return last element of the deque (or null if empty)
	 */
	@Override
	public E last() {
		return deque.last();
	}

	/**
	 * Inserts an element at the front of the deque.
	 *
	 * @param e the new element
	 */
	@Override
	public void addFirst(E e) {
		deque.addFirst(e);
	}

	/**
	 * Inserts an element at the back of the deque.
	 *
	 * @param e the new element
	 */
	@Override
	public void addLast(E e) {
		deque.addLast(e);
	}

	/**
	 * Removes and returns the first element of the deque.
	 *
	 * @return element removed (or null if empty)
	 */
	@Override
	public E removeFirst() {
		return deque.removeFirst();
	}

	/**
	 * Removes and returns the last element of the deque.
	 *
	 * @return element removed (or null if empty)
	 */
	@Override
	public E removeLast() {
		return deque.removeLast();
	}

	/**
	 * Gets the String representation of the deque.
	 * 
	 * @return String representation of the deque
	 */
	public String toString() {
		return deque.toString();
	}

	public static void main(String[] args) {
		LinkedDeque<Integer> dq = new LinkedDeque<>();
		dq.addFirst(0);
		dq.addFirst(1);
		dq.addFirst(2);
		dq.addLast(-1);
		System.out.println(dq);

		dq.removeFirst();
		System.out.println(dq);

		dq.removeLast();
		System.out.println(dq);
	}

}
