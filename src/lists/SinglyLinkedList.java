package lists;

import projectCode20280.List;
import stacks.ArrayStack;

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

    private Node<E> head = null; // reference to first Node of the list
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
        if (isEmpty()) {
            addFirst(e);
        } else {
            Node<E> newest = new Node<>(e, null);
            for (Node<E> temp = head; temp != null; temp = temp.getNext()) {
                if (temp.getNext() == null) {
                    // make the current last Node point to the newly added last Node
                    temp.setNext(newest);
                    break;
                }
            }
            size++;
        }
    }

    /**
     * Inserts an element e at index i of the list.
     *
     * @param i index at which to insert the element e
     * @param e the element to be inserted at given index
     * @throws IllegalArgumentException if specified list index is out of bounds
     */
    @Override
    public void add(int i, E e) throws IllegalArgumentException {
        if (i < 0 || i > size) {
            throw new IllegalArgumentException("Specified index is out of bounds!");
        } else if (i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
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
     * Removes the first element from the list.
     *
     * @return the removed first element
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            // store first element in temp variable and remove the Node
            E removed = head.getElement();
            head = head.getNext();
            size--;
            return removed;
        }
    }

    /**
     * Remove the last element from the list.
     *
     * @return the removed last element
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            return removeFirst();
        } else {
            E removed = null; // element to be removed
            Node<E> temp = head; // temporary Node for list traversal
            while (temp != null) {
                if (temp.getNext().getNext() == null) { // temp is the 2nd last Node
                    removed = temp.getNext().getElement(); // last element is the one to remove
                    temp.setNext(null); // nullify the reference to the last Node
                    size--;
                    break;
                }
                temp = temp.getNext();
            }
            return removed;
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
        if (isEmpty() || i >= size) {
            // cannot remove element if list is empty or specified index is out of bounds
            return null;
        } else if (i == 0) {
            return removeFirst();
        } else {
            E removed = null; // element to be removed
            Node<E> temp = head; // temporary Node for list traversal
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
     * Reverses the order of list elements.
     *
     * @throws IllegalStateException if list is empty
     */
    public void reverse() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
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
     * Recursively reverse the list.
     */
    public void recursiveReverse() {
        head = rev(head);
    }

    /**
     * Helper function to recursively reverse a list.
     *
     * @param start original head Node
     * @return new head Node of the reversed list
     */
    private Node<E> rev(Node<E> start) {
        if (start == null || start.getNext() == null) {
            return start;
        }
        Node<E> newStart = rev(start.getNext());
        start.getNext().setNext(start);
        start.setNext(null);
        return newStart;
    }

    /**
     * Recursively copies a list.
     */
    public SinglyLinkedList<E> recursiveCopy() {
        return copy(head, new SinglyLinkedList<>());
    }

    /**
     * Helper function to recursively copy a list.
     *
     * @param start    the original start Node
     * @param copyList list to store the copy of original list
     * @return a copy of the original list
     */
    private SinglyLinkedList<E> copy(Node<E> start, SinglyLinkedList<E> copyList) {
        if (start == null) {
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
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.add(3, 2);
        System.out.println(ll);

//        System.out.print("Reversed Recursively: ");
//        ll.printReverse(ll.head);
//        System.out.println();

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