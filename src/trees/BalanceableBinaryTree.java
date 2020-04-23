package trees;

import interfaces.Entry;
import interfaces.Position;

/**
 * A special type of LinkedBinaryTree that supports rotate and restructure
 * methods used to balance a binary tree.
 *
 * @param <K> generic type of tree entry keys
 * @param <V> generic type of tree entry values
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 * Reference: Data Structures and Algorithms (Goodrich, Tamassia, Goldwasser)
 */

public class BalanceableBinaryTree<K, V> extends LinkedBinaryTree<Entry<K, V>> {

    /**
     * Gets the given Position's auxiliary balancing information.
     *
     * @param p tree Position
     * @return auxiliary balancing information of the given position
     */
    public int getAux(Position<Entry<K, V>> p) {
        return ((BSTNode<Entry<K, V>>) p).getAux();
    }

    /**
     * Sets the given Position's auxiliary balancing information.
     *
     * @param p     tree Position
     * @param value new auxiliary balancing information of the given position
     */
    public void setAux(Position<Entry<K, V>> p, int value) {
        ((BSTNode<Entry<K, V>>) p).setAux(value);
    }

    // Override node factory function to produce a BSTNode (rather than a Node)
    @Override
    protected Node<Entry<K, V>> createNode(Entry<K, V> e, Node<Entry<K, V>> parent, Node<Entry<K, V>> left,
                                           Node<Entry<K, V>> right) {
        return new BSTNode<>(e, parent, left, right);
    }

    /**
     * Rotates Position p above its parent. Switches between these configurations,
     * depending on whether p is a or p is b.
     *
     * <pre>
     *          b                  a
     *         / \                / \
     *        a  t2             t0   b
     *       / \                    / \
     *      t0  t1                 t1  t2
     * </pre>
     * <p>
     * Caller should ensure that p is not the root.
     *
     * @param p the position to be rotated above its parent
     */
    public void rotate(Position<Entry<K, V>> p) {
        Node<Entry<K, V>> x = validate(p);
        Node<Entry<K, V>> y = x.getParent();
        Node<Entry<K, V>> z = y.getParent();
        if (z == null) {
            setRoot(x);
            x.setParent(null);
        } else {
            relink(z, x, y == z.getLeft());
        }
        if (x == y.getLeft()) {
            relink(y, x.getRight(), true);
            relink(x, y, false);
        } else {
            relink(y, x.getLeft(), false);
            relink(x, y, true);
        }
    }

    // Re-links a parent node with its oriented child node.
    private void relink(Node<Entry<K, V>> parent, Node<Entry<K, V>> child, boolean makeLeftChild) {
        child.setParent(parent);
        if (makeLeftChild) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

    /**
     * Returns the Position that becomes the root of the restructured subtree.
     * <p>
     * Assumes the nodes are in one of the following configurations:
     *
     * <pre>
     *     z=a                 z=c           z=a               z=c
     *    /  \                /  \          /  \              /  \
     *   t0  y=b             y=b  t3       t0   y=c          y=a  t3
     *      /  \            /  \               /  \         /  \
     *     t1  x=c         x=a  t2            x=b  t3      t0   x=b
     *        /  \        /  \               /  \              /  \
     *       t2  t3      t0  t1             t1  t2            t1  t2
     * </pre>
     * <p>
     * The subtree will be restructured so that the node with key b becomes its
     * root.
     *
     * <pre>
     *           b
     *         /   \
     *       a       c
     *      / \     / \
     *     t0  t1  t2  t3
     * </pre>
     *
     * @param x the Position in the tree that must have a grandparent
     * @return the new root Position of the tree
     */
    public Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
        Position<Entry<K, V>> y = parent(x);
        Position<Entry<K, V>> z = parent(y);
        boolean notMatching = (right(y) == x) != (right(z) == y);
        if (notMatching) {
            rotate(x);
            rotate(x);
            return x;
        } else {
            rotate(y);
            return y;
        }
    }

    // -------------- nested BSTNode class --------------
    // this extends the inherited LinkedBinaryTree.Node class
    protected static class BSTNode<E> extends Node<E> {
        int aux = 0;

        BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
            super(e, parent, leftChild, rightChild);
        }

        public int getAux() {
            return aux;
        }

        public void setAux(int value) {
            aux = value;
        }
    } // --------- end of nested BSTNode class ---------

}