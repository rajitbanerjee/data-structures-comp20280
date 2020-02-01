package projectCode20280;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E>, Iterable<E> {

    // Constituent Node of CircularlyLinkedList
    private static class Node<E> {
        private E element; // element stored in the Node
        private Node<E> next; // reference to the next Node in the list

        /**
         * Creates a new node with given element and next node reference.
         *
         * @param element the element that will compose the list
         * @param next    reference to the next Node
         */
        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        // Accessor for element
        E getElement() {
            return element;
        }

        // Accessor for next Node<E>
        Node<E> getNext() {
            return next;
        }

        // Mutator for element
//        public void setElement(E element) {
//            this.element = element;
//        }

        // Mutator for next Node<E>
        void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> tail = null; // reference to the last Node of the list
    private int size = 0; // size tracker

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
    public E removeFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeLast() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns a new ListIterator object.
     *
     * @return instance of ListIterator class
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    // Inner class whose instance is returned by the iterator() method
    private class ListIterator implements Iterator<E> {
        Node<E> temp = tail.getNext();

        @Override
        public boolean hasNext() {
            return temp != tail;
        }

        @Override
        public E next() {
            E ans = temp.getElement();
            temp = temp.getNext();
            return ans;
        }
    }

    /**
     * Insert a Node to the beginning of the list.
     *
     * @param e Node element to be inserted
     */
    @Override
    public void addFirst(E e) {
        if (isEmpty()) {
            // create tail Node and link to itself
            tail = new Node<>(e, tail);
        } else {
            // create new Node to follow the tail
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /**
     * Insert a Node to the end of the list.
     *
     * @param e Node element to be inserted
     */
    @Override
    public void addLast(E e) {
        // add element to the front of the list
        addFirst(e);
        // change the tail to be the newly added Node in the front
        rotate();
    }

    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {
        if (!isEmpty()) {
            tail = tail.getNext();
        }
    }

    /**
     * Gives the String implementation of the list.
     *
     * @return the String containing the comma-separated list elements
     */
    @Override
    public String toString() {
        StringBuilder list = new StringBuilder("[");
        Node<E> temp = tail.getNext();
        while (temp != tail) {
            list.append(temp.getElement().toString()).append(", ");
            temp = temp.getNext();
        }
        list = new StringBuilder(list.substring(0, list.length() - 2));
        list.append("]");
        return list.toString();
    }

    public static void main(String[] args) {
        // TEST 1: Given in skeleton code
        System.out.println("\nTEST 1 from given GitHub code:");
        CircularlyLinkedList<Integer> cll = new CircularlyLinkedList<>();
        for (int i = 10; i < 20; ++i) {
            cll.addLast(i);
        }

        System.out.println(cll);

        cll.removeFirst();
        System.out.println(cll);

        cll.removeLast();

        cll.rotate();
        System.out.println(cll);

        cll.removeFirst();
        cll.rotate();
        System.out.println(cll);

        cll.removeLast();
        cll.rotate();
        System.out.println(cll);

        for (Integer e : cll) {
            System.out.println("value: " + e);
        }

        // TEST 2: Given in practical 1
        System.out.println("\nTEST 2 from Practical 1:");
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
        //LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.add(3, 2);
        System.out.println(ll);
        ll.addFirst(-100);
        ll.addLast(+100);
        System.out.println(ll);
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
        // Removes the item in the specified index ll.remove(2); System.out.println(ll);
        ll.removeFirst();
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
        ll.removeFirst();
        System.out.println(ll);
        ll.addFirst(9999);
        ll.addFirst(8888);
        ll.addFirst(7777);

        System.out.println(ll);
        System.out.println(ll.get(0));
        System.out.println(ll.get(1));
        System.out.println(ll.get(2));
        System.out.println(ll);

    }
}
