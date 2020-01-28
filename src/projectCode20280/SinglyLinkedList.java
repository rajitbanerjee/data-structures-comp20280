package projectCode20280;

import java.util.Iterator;

/**
 * Implementation of a Singly Linked List.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class SinglyLinkedList<E> implements List<E> {

    // Constituent Node of SinglyLinkedList
    private static class Node<E> {
        // Instance variables to represent a Node element and a reference to the next
        // Node
        private E element;
        private Node<E> next;

        /**
         * Creates a new node with given element and next node reference.
         *
         * @param element the element that will compose the list
         * @param next    reference to the next node
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

    private Node<E> head = null; // reference to first Node of the list
    private int size = 0; // keeps track of the size of the list

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
     */
    @Override
    public E get(int i) {
        int index = 0; // temporary index used for list traversal
        Node<E> temp = head; // temporary Node for list traversal
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        while (temp != null) {
            if (index == i) {
                return temp.getElement();
            }
            temp = temp.getNext();
            index++;
        }
        return null;
    }

    /**
     * Inserts an element e at index i of the list.
     *
     * @param i index at which to insert the element e
     * @param e the element to be inserted at given index
     */
    @Override
    public void add(int i, E e) {
        Node<E> newest = new Node<>(e, null); // create Node to be inserted
        Node<E> temp = head; // temporary Node for list traversal
        if (isEmpty()) {
            // if list is empty, insert new Node at the first position
            head = newest;
        } else {
            int index = 0; // temporary index for list traversal
            while (temp != null) {
                if (index == i - 1) {
                    // insert new Node at required index i
                    newest.setNext(temp.getNext());
                    temp.setNext(newest);
                    size++;
                    break;
                }
                temp = temp.getNext();
                index++;
            }
        }
    }

    /**
     * Remove the element at index i of the list.
     *
     * @param i index from which the element needs to be removed
     * @return the element that has been removed, null
     */
    @Override
    public E remove(int i) {
        E removed = null; // element to be removed
        Node<E> temp = head; //temporary Node for list traversal
        if (isEmpty() || i >= size) {
            // cannot remove element if list is empty or specified index is out of bounds
            throw new RuntimeException("Cannot remove any elements!");
        } else {
            int index = 0; // temporary index for list traversal
            while (temp != null) {
                if (index == i - 1) {
                    removed = temp.getNext().getElement(); // element to be removed
                    temp.setNext(temp.getNext().getNext()); // destroy pointer to Node to be removed
                    size--;
                    break;
                }
                temp = temp.getNext();
                index++;
            }
        }
        return removed;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns the current number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes the first element from the list.
     *
     * @return the removed first element
     */
    @Override
    public E removeFirst() {
        E removed;
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
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
     * @return the removed last element
     */
    @Override
    public E removeLast() {
        E removed = null; // element to be removed
        Node<E> temp = head; // temporary Node for list traversal
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
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
