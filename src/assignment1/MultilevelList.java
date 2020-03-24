package assignment1;

/**
 * Assignment 1, Question 3.
 * Implementation of an algorithm to flatten
 * a multi-level linked list.
 *
 * @author Rajit Banerjee, 18202817
 */
public class MultilevelList<E> {
    // Reference to the first Node of a list
    protected Node<E> head;

    public MultilevelList(E[] array) {
        head = makeList(array);
    }

    // Create a linked list from an array
    public Node<E> makeList(E[] array) {
        Node<E> start = null;
        for (int i = array.length - 1; i >= 0; i--) {
            start = new Node<>(array[i], start, null);
        }
        return start;
    }

    // Insert a child Node at a particular index of a list
    public void insertChild(int index, MultilevelList<E> list) {
        Node<E> temp = head;
        int i = 0;
        while (temp != null) {
            if (i == index) {
                temp.setChild(list.head);
            }
            i++;
            temp = temp.getNext();
        }
    }

    public void flatten(Node<E> head) {
        if (head == null) {
            return;
        }
        // Find the tail of the calling list
        Node<E> tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        Node<E> temp = head;
        while (temp != tail) {
            // Flatten if current Node has a child
            if (temp.getChild() != null) {
                tail.setNext(temp.getChild());
                // Update the tail of the main list after flattening
                Node<E> newTail = temp.getChild();
                while (newTail.getNext() != null) {
                    newTail = newTail.getNext();
                }
                tail = newTail;
            }
            temp = temp.getNext();
        }
    }

    /**
     * Gives the String implementation of the list.
     *
     * @return the String containing the comma-separated list elements
     */
    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<E> temp = head;
        while (temp != null) {
            sb.append(temp.getElement().toString()).append(", ");
            temp = temp.getNext();
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }

    protected static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> child;

        /**
         * Creates a new node with given element and next node reference.
         *
         * @param element the element that will compose the list
         * @param next    reference to the next Node
         */
        Node(E element, Node<E> next, Node<E> child) {
            this.element = element;
            this.next = next;
            this.child = child;
        }

        E getElement() {
            return element;
        }

        Node<E> getNext() {
            return next;
        }

        void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getChild() {
            return child;
        }

        public void setChild(Node<E> child) {
            this.child = child;
        }
    }

}