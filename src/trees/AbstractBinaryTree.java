package trees;

import interfaces.BinaryTree;
import interfaces.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract base class providing some functionality of the BinaryTree interface.
 * <p>
 * The following five methods remain abstract, and must be implemented
 * by a concrete subclass:
 * <p>
 * From Tree: root, parent, size
 * <p>
 * From BinaryTree: left, right
 */

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     * <p>
     * Implement the method declared in BinaryTree.
     *
     * @param p A valid Position within the tree
     * @return the Position of the sibling (or null if no sibling exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) {
            // p must be the root
            return null;
        }
        if (p == left(parent)) {
            // (right child might be null)
            return right(parent);
        } else {
            // (left child might be null)
            return left(parent);
        }
    }

    /**
     * Returns the number of children of Position p.
     * <p>
     * Override existing implementation in AbstractTree for efficiency.
     *
     * @param p A valid Position within the tree
     * @return number of children of Position p
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    /**
     * Returns an iterable collection of the Positions representing p's children.
     *
     * @param p A valid Position within the tree
     * @return iterable collection of the Positions of p's children
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        // max capacity of 2
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    }

    /**
     * Returns an iterable collection of the positions of the
     * tree using inorder traversal.
     *
     * @return iterable collection of the tree's positions using
     * inorder traversal
     */
    @Override
    public Iterable<Position<E>> positions() {
        return inorder();
    }

    /**
     * Returns an iterable collection of positions of the tree,
     * reported using inorder traversal.
     *
     * @return iterable collection of the tree's positions reported
     * using inorder traversal
     */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            // fill the snapshot recursively
            inorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    // Adds positions of the subtree rooted at p to the given snapshot
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null) {
            inorderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if (right(p) != null) {
            inorderSubtree(right(p), snapshot);
        }
    }

}