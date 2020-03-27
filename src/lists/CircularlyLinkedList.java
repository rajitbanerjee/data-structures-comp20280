package lists;

import projectCode20280.List;

import java.util.Iterator;

/**
 * Implementation of a Circularly Linked List.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 * Reference: Data Structures and Algorithms (Goodrich, Tamassia, Goldwasser)
 */
public class CircularlyLinkedList<E> implements List<E>, Iterable<E> {
    private Node<E> tail = null;
    private int size = 0;

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
     * Insert a Node to the beginning of the list.
     *
     * @param e Node element to be inserted
     */
    @Override
    public void addFirst(E e) {
        if (isEmpty()) {
            // Create tail Node and link to itself
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            // Create new Node to follow the tail
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
        addFirst(e);
        rotate();
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
        if (i < 0 || i > size) {
            throw new RuntimeException("Specified index is out of bounds!");
        } else if (i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
        } else {
            Node<E> newest = new Node<>(e, null); // Create Node to be inserted
            Node<E> temp = tail.getNext(); // Temporary Node for list traversal
            for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i - 1) {
                    // Insert new Node at required index i
                    newest.setNext(temp.getNext());
                    temp.setNext(newest);
                    break;
                }
            }
            size++;
        }
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

    /**
     * Returns the element at index i of the List.
     *
     * @param i the index of the list which contains required element
     * @return the element at index i
     */
    @Override
    public E get(int i) {
        E ans = null;
        int index = 0; // Temporary index used for list traversal
        Iterator<E> itr = iterator();
        if (isEmpty()) {
            return null;
        }
        while (itr.hasNext()) {
            if (index == i) {
                ans = itr.next();
                break;
            }
            itr.next();
            index++;
        }
        return ans;
    }

    /**
     * Remove the first Node from the list.
     *
     * @return the removed first element, null if empty
     */
    @Override
    public E removeFirst() {
        E removed;
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            removed = tail.getElement();
            tail = null;
            size--;
        } else {
            removed = tail.getNext().getElement();
            tail.setNext(tail.getNext().getNext());
            size--;
        }
        return removed;
    }

    /**
     * Remove the last Node from the list.
     *
     * @return the removed last element, null if empty
     */
    @Override
    public E removeLast() {
        E removed;
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            removed = tail.getElement();
            tail = null;
            size--;
        } else {
            Node<E> temp = tail.getNext();
            removed = tail.getElement();
            int i = 0; // Temporary index for loop control
            while (i < size - 1) {
                // Traverse the list until the 2nd last Node is reached
                i++;
                temp = temp.getNext();
            }
            // Make the 2nd last Node link to the first Node after the former tail
            temp.setNext(tail.getNext());
            // Update the tail Node
            tail = temp;
            size--;
        }
        return removed;
    }

    /**
     * Remove the element at index i of the list.
     *
     * @param i index from which the element needs to be removed
     * @return the element that has been removed, null if empty or out of bounds
     */
    @Override
    public E remove(int i) {
        if (isEmpty() || i >= size) {
            // Cannot remove element if list is empty or specified index is out of bounds
            return null;
        } else if (i == 0) {
            return removeFirst();
        } else {
            E removed = null; // Element to be removed
            Node<E> temp = tail.getNext(); // Temporary Node for list traversal
            for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i - 1) {
                    removed = temp.getNext().getElement(); // Element to be removed
                    temp.setNext(temp.getNext().getNext()); // Destroy pointer to Node to be removed
                    size--;
                    break;
                }
            }
            return removed;
        }
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
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (E e : this) {
            sb.append(e.toString()).append(", ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }

    // Constituent Node of CircularlyLinkedList
    private static class Node<E> {
        private E element; // Element stored in the Node
        private Node<E> next; // Reference to the next Node in the list

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

        // Mutator for next Node<E>
        void setNext(Node<E> next) {
            this.next = next;
        }
    }

    // Inner class whose instance is returned by the iterator() method
    private class ListIterator implements Iterator<E> {
        Node<E> temp = tail;
        int index = 0;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public E next() {
            E ans = temp.getNext().getElement();
            temp = temp.getNext();
            index++;
            return ans;
        }
    }

}