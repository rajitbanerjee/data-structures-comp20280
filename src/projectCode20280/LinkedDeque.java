package projectCode20280;

/**
 * Implementation of a linked list based Deque.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class LinkedDeque<E> implements Deque<E> {
    // Implement deque with DLL as base
    private DoublyLinkedList<E> deque = new DoublyLinkedList<>();

	/**
	 * Returns the number of elements in the deque.
	 *
	 * @return number of elements in the deque
	 */
	@Override
	public int size() {
		return 0;
	}

	/**
	 * Tests whether the deque is empty.
	 *
	 * @return true if the deque is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Returns (but does not remove) the first element of the deque.
	 *
	 * @return first element of the deque (or null if empty)
	 */
	@Override
	public E first() {
		return null;
	}

	/**
	 * Returns (but does not remove) the last element of the deque.
	 *
	 * @return last element of the deque (or null if empty)
	 */
	@Override
	public E last() {
		return null;
	}

	/**
	 * Inserts an element at the front of the deque.
	 *
	 * @param e the new element
	 */
	@Override
	public void addFirst(E e) {

	}

	/**
	 * Inserts an element at the back of the deque.
	 *
	 * @param e the new element
	 */
	@Override
	public void addLast(E e) {

	}

	/**
	 * Removes and returns the first element of the deque.
	 *
	 * @return element removed (or null if empty)
	 */
	@Override
	public E removeFirst() {
		return null;
	}

	/**
	 * Removes and returns the last element of the deque.
	 *
	 * @return element removed (or null if empty)
	 */
	@Override
	public E removeLast() {
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
