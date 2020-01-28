package projectCode20280;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E>, Iterable<E> {

    // Constituent Node of DoublyLinkedList
    private static class Node<E> {
        private E element; // element stored in the Node
        private Node<E> next; // reference to next Node in the list
        private Node<E> prev; // reference to previous Node in the List

		/**
		 * Creates a new node with given element and next node reference.
		 *
		 * @param element the element that will compose the list
		 * @param next    reference to the next Node
		 * @param prev reference to the previous Node
		 */
        Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        // Accessor for Node element
        E getElement() {
            return element;
        }

        // Accessor for reference to next Node
        Node<E> getNext() {
            return next;
        }

        // Accessor for reference to previous Node
        Node<E> getPrev() {
            return prev;
        }

        // Mutator for Node element
        public void setElement(E element) {
            this.element = element;
        }

        // Mutator for reference to next Node
        public void setNext(Node<E> next) {
            this.next = next;
        }

        // Mutator for reference to previous Node
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

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }
    }


}
