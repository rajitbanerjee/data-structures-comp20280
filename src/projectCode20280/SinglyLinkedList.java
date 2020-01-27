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
    private Node<E> tail = null; // reference to last Node of the list
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
        if (temp == null) {
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
        Node<E> newest = new Node<>(e, null);
        Node<E> temp = head;
        if (temp == null) {
            head = newest;
        } else {
            int index = 0;
            while (temp != null) {
                if (index == i - 1) {
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

    /**
     * Returns the current number of elements in the list.
     */
    @Override
    public int size() {
        return size;
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
