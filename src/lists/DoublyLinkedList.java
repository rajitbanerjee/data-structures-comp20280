package lists;

import projectCode20280.List;

import java.util.Iterator;

/**
 * Implementation of a Doubly Linked List.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class DoublyLinkedList<E> implements List<E> {

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
         * @param prev    reference to the previous Node
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
//        public void setElement(E element) {
//            this.element = element;
//        }

        // Mutator for reference to next Node
        void setNext(Node<E> next) {
            this.next = next;
        }

        // Mutator for reference to previous Node
        void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    // Sentinel Nodes
    private Node<E> header = new Node<>(null, null, null);
    private Node<E> trailer = new Node<>(null, null, header);
    // Size tracker
    private int size = 0;

    public DoublyLinkedList() {
        header.setNext(trailer);
    }

    /**
     * Insert a Node element in between two given Nodes
     *
     * @param e           the element to be inserted
     * @param predecessor the Node just before the new Node
     * @param successor   the Node just after the new Node
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, successor, predecessor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Finds the current number of Nodes in the list.
     *
     * @return the instance variable size which stores the list's length
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return {@code true} if the list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Insert a Node at the front of the list.
     *
     * @param e Node element to be inserted
     */
    @Override
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /**
     * Insert a Node at the end of the list.
     *
     * @param e Node element to be inserted
     */
    @Override
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Insert a Node at a given index
     *
     * @param i index at which Node is to be inserted
     * @param e Node element to be inserted
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
            Node<E> temp = header.getNext(); // temporary Node for list traversal
            for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i) {
                    // insert Node when index is found
                    addBetween(e, temp.getPrev(), temp);
                    break;
                }
            }
        }
    }

    /**
     * Gets the first element of the list.
     *
     * @return the element at the first Node of the list, null if empty
     */
    public E first() {
        if (isEmpty()) {
            return null;
        } else {
            return header.getNext().getElement();
        }
    }

    /**
     * Gets the last element of the list.
     *
     * @return the element at the last Node of the list, null if empty
     */
    public E last() {
        if (isEmpty()) {
            return null;
        } else {
            return trailer.getPrev().getElement();
        }
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
        int index = 0; // temporary index used for list traversal
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
        Node<E> temp = header.getNext();
        int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return temp != trailer;
        }

        @Override
        public E next() {
            E ans = temp.getElement();
            temp = temp.getNext();
            nextIndex++;
            return ans;
        }

        /*
        public boolean hasPrevious() {
            return temp != header;
        }

        public E previous() {
            E ans = temp.getElement();
            temp = temp.getPrev();
            nextIndex--;
            return ans;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }
        */
    }

    /**
     * Deletes the first Node of the list.
     *
     * @return the removed first Node in the list, null if empty
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            E removed = header.getNext().getElement();
            Node<E> newFirst = header.getNext().getNext();
            header.setNext(newFirst);
            newFirst.setPrev(header);
            size--;
            return removed;
        }
    }

    /**
     * Deletes the last Node of the list.
     *
     * @return the removed last Node in the list, null if empty
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            return removeFirst();
        } else {
            E removed = trailer.getPrev().getElement();
            Node<E> newLast = trailer.getPrev().getPrev();
            trailer.setPrev(newLast);
            newLast.setNext(trailer);
            size--;
            return removed;
        }
    }

    /**
     * Remove the element at index i of the list.
     *
     * @param i index from which the element needs to be removed
     * @return the element that has been removed, null is empty or index out of bounds
     */
    @Override
    public E remove(int i) {
        if (isEmpty() || i >= size) {
            // cannot remove element if list is empty or specified index is out of bounds
            return null;
        } else if (i == 0) {
            return removeFirst();
        } else {
            E removed = null; // element to be removed
            Node<E> temp = header.getNext(); //temporary Node for list traversal
            for (int index = 0; index < size; index++, temp = temp.getNext()) {
                if (index == i - 1) {
                    removed = temp.getNext().getElement(); // element to be removed
                    temp.setNext(temp.getNext().getNext()); // destroy pointer to Node to be removed
                    size--;
                    break;
                }
            }
            return removed;
        }
    }

    /**
     * Recursively copies a list.
     */
    public DoublyLinkedList<E> recursiveCopy() {
        return copy(header.getNext(), new DoublyLinkedList<>());
    }

    /**
     * Helper function to recursively copy a list.
     *
     * @param start    the original start Node
     * @param copyList list to store the copy of original list
     * @return a copy of the original list
     */
    private DoublyLinkedList<E> copy(Node<E> start, DoublyLinkedList<E> copyList) {
        if (start == trailer) {
            return copyList;
        } else {
            copyList.addLast(start.getElement());
            return copy(start.getNext(), copyList);
        }
    }

    /**
     * Gives the String implementation of the list.
     *
     * @return the String containing the comma-separated list elements
     */
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (E e : this) {
            sb.append(e.toString()).append(", ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }

    /*
    public static void main(String[] args) {
        // TEST 1: Given in skeleton code
        System.out.println("\nTEST 1 from given GitHub code:");
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(0);
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addLast(-1);
        System.out.println(dll);

        dll.removeFirst();
        System.out.println(dll);

        dll.removeLast();
        System.out.println(dll);

        for (Integer e : dll) {
            System.out.println("value: " + e);
        }

        // TEST 2: Given in practical 1
        System.out.println("\nTEST 2 from Practical 1:");
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
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
     */

}
