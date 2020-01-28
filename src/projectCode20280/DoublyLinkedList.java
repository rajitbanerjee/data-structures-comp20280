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
        public void setElement(E element) {
            this.element = element;
        }

        // Mutator for reference to next Node
        void setNext(Node<E> next) {
            this.next = next;
        }

        // Mutator for reference to previous Node
        void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, null, header);
        header.setNext(trailer);
        size = 0;
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, successor, predecessor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

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
        Iterator<E> itr = iterator();
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
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
}