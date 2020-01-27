package projectCode20280;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

    // Inner class to describe the nodes that compose the list
    private static class Node<E> {
        // Instance variables to represent a Node element and a reference to the next Node
        private E element;
        private Node<E> next;

        /**
         * Creates a new node with given element and next node reference.
         *
         * @param element the element that will compose the list
         * @param next    reference to the next node
         */
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        //  Accessor for element
        public E getElement() {
            return element;
        }

        // Accessor for next Node<E>
        public Node<E> getNext() {
            return next;
        }

        // Mutator for element
        public void setElement(E element) {
            this.element = element;
        }

        // Mutator for next Node<E>
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    @Override
    public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int i, E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public E remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}	
	

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        SinglyLinkedList<String> sll = new SinglyLinkedList<>();
        for (String s : alphabet) {
            sll.addFirst(s);
            sll.addLast(s);
        }
        System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println(sll.toString());
		
		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());
		
		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}


}
