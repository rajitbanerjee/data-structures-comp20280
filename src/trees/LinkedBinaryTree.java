package trees;

import interfaces.Position;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Concrete implementation of a binary tree using a node-based, linked structure.
 * <p>
 * 1. Implements previously abstract methods from AbstractTree (from Tree ADT): root, parent, size
 * <p>
 * 2. Implements previously abstract methods from AbstractBinaryTree (from BinaryTree ADT): left, right
 * <p>
 * 3. Other methods in Tree ADT and BinaryTree ADT are implemented in AbstractTree and AbstractBinaryTree.
 * <p>
 * 4. Allows level order (createLevelOrder), direct and BST order construction of the tree.
 * <p>
 * 5. Additional public methods: addRoot, addLeft, addRight, insert, set, attach, remove, toString,
 * countLeftExternalNodes, countDescendants
 * <p>
 * 6. Contains an inner Node class which represents a tree node.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 * Reference: Data Structures and Algorithms (Goodrich, Tamassia, Goldwasser)
 */

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    private Node<E> root = null;
    private int size = 0;

    /**
     * Constructs an empty binary tree.
     */
    public LinkedBinaryTree() {
    }

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        System.out.println("~ LinkedBinaryTree ~");
        System.out.println("TEST 1, direct construction:");
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
        Position<Integer> root = bt.addRoot(12);
        Position<Integer> p1 = bt.addLeft(root, 25);
        bt.addRight(p1, 36);
        Position<Integer> p2 = bt.addRight(root, 31);
        bt.addRight(p2, 90);
        Position<Integer> p3 = bt.addLeft(p1, 58);
        bt.addRight(p3, 75);
        Position<Integer> p4 = bt.addLeft(p3, 62);
        Position<Integer> p5 = bt.addLeft(p2, 42);

        System.out.println(bt.toStringTree());
        System.out.println("bt size: " + bt.size());
        System.out.println("bt inorder(): " + bt.inorder());
        System.out.println("bt preorder(): " + bt.preorder());
        System.out.println("bt postorder(): " + bt.postorder());

        System.out.println("bt height: " + bt.height(root));
        System.out.println("bt depth root: " + bt.depth(root));
        System.out.println("bt depth 62: " + bt.depth(p4));
        System.out.println("bt depth 42: " + bt.depth(p5));

        System.out.println("\nTEST 2, level order construction:");
        Integer[] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
        bt.createLevelOrder(arr);
        System.out.println("Given level order array: " + Arrays.toString(arr));
        System.out.println(bt.toStringTree());
        System.out.println("bt size: " + bt.size());
        System.out.println("bt inorder(): " + bt.inorder());
        System.out.println("bt preorder(): " + bt.preorder());
        System.out.println("bt postorder(): " + bt.postorder());

        System.out.println("bt height: " + bt.height(bt.root()));
        System.out.println("bt depth root: " + bt.depth(bt.root()));


        System.out.println("\nTEST 3, sorted order construction:");
        bt = new LinkedBinaryTree<>();
        for (Integer i : arr) {
            bt.insert(i);
        }
        System.out.println("Given array: " + Arrays.toString(arr));
        System.out.println("After insertion in sorted order:");
        System.out.println(bt.toStringTree());
        System.out.println("bt size: " + bt.size());
        System.out.println("bt (default inorder): " + bt);
        System.out.println("bt inorder(): " + bt.inorder());
        System.out.println("bt preorder(): " + bt.preorder());
        System.out.println("bt postorder(): " + bt.postorder());

        System.out.println("bt root: " + bt.root());
        System.out.println("bt depth root: " + bt.depth(bt.root()));
    }

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

    // Factory function to create a new node storing element e
    protected Node<E> createNode(E e, Node<E> parent) {
        return new Node<>(e, parent, null, null);
    }

    // Modify the root of the tree (used in BalanceableBinaryTree)
    protected void setRoot(Node<E> root) {
        this.root = root;
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

    // Update methods supported by this class ---------------------------------------

    /**
     * Fills a binary tree from in level order from a given array.
     *
     * @param arr to be used for level order construction
     */
    public void createLevelOrder(E[] arr) {
        root = createLevelOrder(arr, null, 0);
    }

    /**
     * Fills a binary tree from in level order from a given ArrayList.
     *
     * @param arr to be used for level order construction
     */
    public void createLevelOrder(ArrayList<E> arr) {
        root = createLevelOrder(arr, null, 0);
    }

    // Helper for level order tree construction from an array
    private Node<E> createLevelOrder(E[] arr, Node<E> parent, int i) {
        if (i < arr.length) {
            Node<E> newest = createNode(arr[i], parent);
            newest.setLeft(createLevelOrder(arr, newest.getLeft(), 2 * i + 1));
            newest.setRight(createLevelOrder(arr, newest.getRight(), 2 * i + 2));
            size++;
            return newest;
        } else {
            return parent;
        }
    }

    // Helper for level order tree construction from ArrayList
    private Node<E> createLevelOrder(ArrayList<E> arr, Node<E> parent, int i) {
        if (i < arr.size()) {
            Node<E> newest = createNode(arr.get(i), parent);
            newest.setLeft(createLevelOrder(arr, newest.getLeft(), 2 * i + 1));
            newest.setRight(createLevelOrder(arr, newest.getRight(), 2 * i + 2));
            size++;
            return newest;
        } else {
            return parent;
        }
    }

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
     * Insert an element into the tree in sorted order.
     *
     * @param e element to be inserted
     */
    public void insert(E e) {
        // Recursively add from root
        root = addRecursive(root, e);
        ++size;
    }

    // Recursively add Nodes to binary tree in proper position
    @SuppressWarnings("unchecked")
    private Node<E> addRecursive(Node<E> p, E e) {
        if (p == null) {
            return createNode(e, null);
        } else {
            if (((Comparable<E>) e).compareTo(p.getElement()) < 0) {
                p.setLeft(addRecursive(p.getLeft(), e));
            } else {
                p.setRight(addRecursive(p.getRight(), e));
            }
            return p;
        }
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
     * Attaches trees leftTree and rightTree, respectively, as the left and right subtree of the
     * leaf Position p. As a side effect, leftTree and rightTree are set to empty trees.
     *
     * @param p         a leaf of the tree
     * @param leftTree  an independent tree whose structure becomes the left child of p
     * @param rightTree an independent tree whose structure becomes the right child of p
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> leftTree,
                       LinkedBinaryTree<E> rightTree) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p must be a leaf!");
        }
        size += leftTree.size() + rightTree.size();
        if (!leftTree.isEmpty()) {
            node.setLeft(leftTree.root);
            leftTree.root.setParent(node);
            leftTree.root = null;
            leftTree.size = 0;
        }
        if (!rightTree.isEmpty()) {
            node.setRight(rightTree.root);
            rightTree.root.setParent(node);
            rightTree.root = null;
            rightTree.size = 0;
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
        if (node == root) {
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

    /**
     * Gets the String representation of the binary tree.
     *
     * @return String representation of the binary tree.
     */
    @Override
    public String toString() {
        return positions().toString();
    }

    /**
     * Displays the heap using BinaryTreePrinter.
     *
     * @return String representation of the tree heap
     */
    public String toStringTree() {
        BinaryTreePrinter<E> btp = new BinaryTreePrinter<>(this);
        return btp.toString();
    }

    // Extra functionality for lab questions ------------------------------------------

    /**
     * Algorithm to count left external nodes.
     *
     * @return the number of left external nodes in the tree.
     * @throws IllegalArgumentException if any Position in the tree is invalid
     */
    public int countLeftExternalNodes() throws IllegalArgumentException {
        int count = 0;
        if (isEmpty() || size() == 1) {
            return 0;
        } else {
            for (Position<E> p : positions()) {
                try {
                    Node<E> node = validate(p);
                    Node<E> parent = validate(parent(p));
                    Node<E> leftChild = validate(left(parent));
                    if (isExternal(p) && node == leftChild) {
                        count++;
                    }
                } catch (Exception ignored) {
                    // Position not valid
                }
            }
        }
        return count;
    }

    /**
     * Counts the descendants of a given Position.
     *
     * @param p the Position whose descendants are to be counted.
     * @return the number of descendants of the given position.
     */
    public int countDescendants(Position<E> p) {
        if (isEmpty() || size == 1) {
            return 0;
        } else {
            return count(p) - 1;
        }
    }

    // Count all nodes in subtree including first node
    private int count(Position<E> p) {
        if (p == null) {
            return 0;
        } else {
            return 1 + count(left(p)) + count(right(p));
        }
    }

    /**
     * Nested static class for a binary tree node.
     * (Made public to allow access in assignment2.BTree)
     */
    public static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        /**
         * Constructor.
         *
         * @param element Node element
         * @param parent  Parent node
         * @param left    Left child node
         * @param right   Right child node
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
         */
        @Override
        public E getElement() {
            return element;
        }

        // Setter methods
        public void setElement(E element) {
            this.element = element;
        }

        // Other getter methods
        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            // "null" printing required when using BinaryTreePrinter
            return element == null ? "null" : element.toString();
        }
    }

}