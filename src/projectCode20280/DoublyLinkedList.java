package projectCode20280;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E>, Iterable<E> {

	// Constituent Node of DoublyLinkedList
	private static class Node<E> {
		private E element; // element stored in the Node
		private Node<E> next; // reference to next Node in the list
		private Node<E> prev; // reference to previous Node in the List

		Node(E element, Node<E> next, Node<E> prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}

		E getElement() {
			return element;
		}

		Node<E> getNext() {
			return next;
		}

		Node<E> getPrev() {
			return prev;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		// TODO
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
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
		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
           ll.addFirst(0);
           ll.addFirst(1);
           ll.addFirst(2);
           ll.addLast(-1);
           System.out.println(ll);
           
           ll.removeFirst();
           System.out.println(ll);

           ll.removeLast();
           System.out.println(ll);
           
           for(Integer e: ll) {
                   System.out.println("value: " + e);
           }
	}

	
}
