package trees;

import projectCode20280.AbstractBinaryTree;
import projectCode20280.Position;

/**
 * Concrete implementation of a binary tree using a node-based, linked structure.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */
public class LinkedBinaryTree<E extends Comparable<E>> extends AbstractBinaryTree<E> {
    /**
     * Nested static class for a binary tree node.
     */
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        /**
         * Constructor
         */
        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            setElement(element);
            setParent(parent);
            setLeft(left);
            setRight(right);
        }

        /**
         * Returns the element stored at this position.
         *
         * @return the stored element
         * @throws IllegalStateException if position no longer valid
         */
        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        // Other getter methods
        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        // Setter methods
        public void setElement(E element) {
            this.element = element;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    /**
     * Factory function to create a new node storing element e.
     */
    protected Node<E> createNode(E e, Node<E> parent) {
        return new Node<>(e, parent, null, null);
    }

    protected Node<E> root = null;
    private int size = 0;

    /**
     * Constructs an empty binary tree.
     */
    public LinkedBinaryTree() {
    }

    // non-public utility

    /**
     * Verifies that a Position belongs to the appropriate class, and is
     * not one that has been previously removed. Note that our current
     * implementation does not actually verify that the position belongs
     * to this particular list instance.
     *
     * @param p a Position (that should belong to this tree)
     * @return the underlying Node instance for the position
     * @throws IllegalArgumentException if an invalid position is detected
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) {
            // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    // Accessor methods (not already implemented in AbstractBinaryTree) ------------

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     *
     * @return root Position of the tree (or null if tree is empty)
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the Position of p's parent (or null if p is root).
     *
     * @param p A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the Position of p's left child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the left child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * Returns the Position of p's right child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the right child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    // update methods supported by this class ----------------------------------

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     *
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree needs to be empty to add new root!");
        }
        root = createNode(e, null);
        size = 1;
        return root;
    }

    /**
     * Insert an element into the tree in proper BST order.
     *
     * @param e element to be inserted
     */
    public void insert(E e) {
        //recursively add from root
        root = addRecursive(root, e);
        ++size;
    }

    // Recursively add Nodes to binary tree in proper position
    private Node<E> addRecursive(Node<E> p, E e) {
        if (p == null) {
            return createNode(e, null);
        } else {
            if (e.compareTo(p.getElement()) < 0) {
                p.setLeft(addRecursive(p.getLeft(), e));
            } else {
                p.setRight(addRecursive(p.getRight(), e));
            }
            return p;
        }
    }

    /**
     * Creates a new left child of Position p storing element e and returns its Position.
     *
     * @param p the Position to the left of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("p already has a left child!");
        }
        Node<E> leftChild = createNode(e, parent);
        parent.setLeft(leftChild);
        size++;
        return leftChild;
    }

    /**
     * Creates a new right child of Position p storing element e and returns its Position.
     *
     * @param p the Position to the right of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p already has a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("p already has a right child!");
        }
        Node<E> rightChild = createNode(e, parent);
        parent.setRight(rightChild);
        size++;
        return rightChild;
    }

    /**
     * Replaces the element at Position p with element e and returns the replaced element.
     *
     * @param p the relevant Position
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E replaced = node.getElement();
        node.setElement(e);
        return replaced;
    }

    /**
     * Attaches trees t1 and t2, respectively, as the left and right subtree of the
     * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
     *
     * @param p  a leaf of the tree
     * @param t1 an independent tree whose structure becomes the left child of p
     * @param t2 an independent tree whose structure becomes the right child of p
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1,
                       LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p must be a leaf!");
        }
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) {
            node.setLeft(t1.root);
            t1.root.setParent(node);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {
            node.setRight(t2.root);
            t2.root.setParent(node);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes the node at Position p and replaces it with its child, if any.
     *
     * @param p the relevant Position
     * @return element that was removed
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p has two children.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("p has two children!");
        }
        Node<E> child = node.getLeft() != null ? node.getLeft() : node.getRight();
        if (child != null) {
            child.setParent(node.getParent());
        }
        if (root == node) {
            root = child;
        } else {
            Node<E> parent = node.getParent();
            if (parent.getLeft() == node) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        E removed = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return removed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Position<E> p : positions()) {
            sb.append(p.getElement()).append(", ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }

    // Extra functionality for lab and assignment questions ----------------

    // Algorithm to count left external nodes
    public int countLeftExternalNodes() {
        int count = 0;
        if (isEmpty() || size() == 1) {
            return 0;
        } else {
            for (Position<E> p : positions()) {
                Node<E> node = validate(p);
                if (isExternal(p) && node.getParent().getLeft() == node) {
                    count++;
                }
            }
        }
        return count;
    }

    // Algorithm to count descendants
    public int countDescendants(Position<E> p) {
        if (p == null) {
            return 0;
        } else {
            // exclude node itself from the count
            return countSubtree(p) - 1;
        }
    }

    // Count all nodes in subtree including first node
    public int countSubtree(Position<E> p) {
        if (p == null) {
            return 0;
        } else {
            return 1 + countDescendants(left(p)) +
                    countDescendants(right(p));
        }
    }

    // Algorithm to flatten a binary tree into a linked list
    public void flatten(Node<E> root) {
        if (root == null || isExternal(root)) {
            return;
        }
        if (root.getLeft() != null) {
            flatten(root.getLeft());

            // temporarily store the original right child of the root
            Node<E> originalRight = root.getRight();
            // move the root's left child to it's new right child
            root.setRight(root.getLeft());
            root.setLeft(null);

            // find the rightmost end of the root's right child
            Node<E> insertPosition = root.getRight();
            while (insertPosition.getRight() != null) {
                insertPosition = insertPosition.getRight();
            }
            // set the rightmost end's right child to be the original right child
            insertPosition.setRight(originalRight);
        }
        flatten(root.getRight());
    }


    public static void main(String[] args) {
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();

        int[] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
        for (int i : arr) {
            bt.insert(i);
        }
        System.out.println("bt: " + bt.size() + " " + bt);

        // test flatten
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> rootLeft = tree.addLeft(root, 2);
        Position<Integer> rootRight = tree.addRight(root, 5);
        tree.addLeft(rootLeft, 3);
        tree.addRight(rootLeft, 4);
        tree.addRight(rootRight, 6);

        System.out.println("in-order: " + tree);
        tree.flatten(tree.root);
        System.out.println("flat: " + tree);
    }

} 
