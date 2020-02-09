package projectCode20280;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a Singly Linked List.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class SinglyLinkedList<E> implements List<E> {

    // Constituent Node of SinglyLinkedList
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
        public void setElement(E element) {
            this.element = element;
        }

        // Mutator for next Node<E>
        void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head = null;// reference to first Node of the list
    private int size = 0; // keeps track of the size of the list

    /**
     * Returns the current number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return {@code true} if list if empty, else {@code false}
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the element at index i of the List.
     *
     * @param i the index of the list which contains required element
     * @return the element at index i
     * @throws NoSuchElementException if list is empty
     */
    @Override
    public E get(int i) throws NoSuchElementException {
        int index = 0; // temporary index used for list traversal
        Iterator<E> itr = iterator();
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        while (itr.hasNext()) {
            if (index == i) {
                return itr.next();
            }
            itr.next();
            index++;
        }
        return null;
    }

    /**
     * Inserts an element e at index i of the list.
     *
     * @param i index at which to insert the element e
     * @param e the element to be inserted at given index
     * @throws RuntimeException if specified list index is out of bounds
     */
    @Override
    public void add(int i, E e) throws RuntimeException {
        if (i > size) {
            throw new RuntimeException("Specified index is greater than List size!");
        } else if (i == size) {
            // add element to the end of the list
            addLast(e);
        } else if (isEmpty()) {
            // if list is empty insert new Node at the first position
            addFirst(e);
        } else {
            Node<E> newest = new Node<>(e, null); // create Node to be inserted
            Node<E> temp = head; // temporary Node for list traversal
            for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i - 1) {
                    // insert new Node at required index i
                    newest.setNext(temp.getNext());
                    temp.setNext(newest);
                    break;
                }
            }
            size++;
        }
    }

    /**
     * Remove the element at index i of the list.
     *
     * @param i index from which the element needs to be removed
     * @return the element that has been removed, null
     * @throws NoSuchElementException if list is empty or specified index is out of bounds
     */
    @Override
    public E remove(int i) throws NoSuchElementException {
        E removed = null; // element to be removed
        if (isEmpty() || i >= size) {
            // cannot remove element if list is empty or specified index is out of bounds
            throw new NoSuchElementException();
        } else {
            Node<E> temp = head; //temporary Node for list traversal
            for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i - 1) {
                    removed = temp.getNext().getElement(); // element to be removed
                    temp.setNext(temp.getNext().getNext()); // destroy pointer to Node to be removed
                    size--;
                    break;
                }
            }
        }
        return removed;
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
        Node<E> temp = head;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public E next() {
            E ans = temp.getElement();
            temp = temp.getNext();
            return ans;
        }
    }

    /**
     * Removes the first element from the list.
     *
     * @return the removed first element
     * @throws NoSuchElementException if list is empty
     */
    @Override
    public E removeFirst() throws NoSuchElementException {
        E removed;
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            // store first element in temp variable and remove the Node
            removed = head.getElement();
            head = head.getNext();
            size--;
        }
        return removed;
    }

    /**
     * Remove the last element from the list
     *
     * @return the removed last element
     * @throws NoSuchElementException if list is empty
     */
    @Override
    public E removeLast() throws NoSuchElementException {
        E removed = null; // element to be removed
        Node<E> temp = head; // temporary Node for list traversal
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            while (temp != null) {
                if (temp.getNext().getNext() == null) { // temp is the 2nd last Node
                    removed = temp.getNext().getElement(); // last element is the one to remove
                    temp.setNext(null); // nullify the reference to the last Node
                    size--;
                    break;
                }
                temp = temp.getNext();
            }
        }
        return removed;
    }

    /**
     * Adds an element to the beginning of the list.
     *
     * @param e the element to be added to the list
     */
    @Override
    public void addFirst(E e) {
        head = new Node<>(e, head);
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the element to the added to the list
     */
    @Override
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        Node<E> temp = head; // temporary Node for list traversal
        if (isEmpty()) {
            head = new Node<>(e, head);
        } else {
            while (temp != null) {
                if (temp.getNext() == null) {
                    // make the current last Node point to the newly added last Node
                    temp.setNext(newest);
                    break;
                }
                temp = temp.getNext();
            }
        }
        size++;
    }

    /**
     * Reverses the order of list elements.
     *
     * @throws RuntimeException if list is empty
     */
    public void reverse() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        } else {
            ArrayStack<E> stack = new ArrayStack<>(size);
            for (E elem : this) {
                // add list elements to Stack
                stack.push(elem);
            }
            Node<E> temp = head;
            while (temp != null) {
                // reverse list order using LIFO concept
                temp.setElement(stack.pop());
                temp = temp.getNext();
            }
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
        for (E e : this) {
            list.append(e.toString()).append(", ");
        }
        list = new StringBuilder(list.substring(0, list.length() - 2));
        list.append("]");
        return list.toString();
    }

    public static void main(String[] args) {
        // TEST 1: Given in skeleton code
        System.out.println("\nTEST 1 from given GitHub code:");
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
        //check reverse method
        ll.reverse();
        System.out.println("Reversed list: " + ll);
    }

}