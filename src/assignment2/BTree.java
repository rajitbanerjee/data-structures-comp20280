package assignment2;

import interfaces.Position;
import trees.LinkedBinaryTree;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * Assignment 2, Questions 1, 2, 3.
 * BTree adds the following methods to a LinkedBinaryTree:
 * <p>
 * 1. isSymmetrical() - Check if tree's structure has mirror symmetry.
 * <p>
 * 2. mirror() - Converts the tree to its mirror image.
 * <p>
 * 3. dist(e1, e2) - Finds the path length between two tree nodes with the given elements.
 *
 * @author Rajit Banerjee, 18202817
 */

public class BTree<E extends Comparable<E>> extends LinkedBinaryTree<E> {

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();
        Random rnd = new Random();
        java.util.List<Integer> rands = rnd.ints(1, 1000).
                limit(16).distinct().boxed().collect(Collectors.toList());
        System.out.println("Items to insert: " + rands);
        for (Integer i : rands) {
            tree.insert(i);
        }
        System.out.println("Original tree: " + tree.toStringTree());
        tree.mirror();
        System.out.println("Mirror tree:" + tree.toStringTree());
        System.out.println("tree.isSymmetrical(): " + tree.isSymmetrical());

        System.out.println("\nDistance between nodes:");
        int i1 = rnd.nextInt(rands.size());
        int i2 = rnd.nextInt(rands.size());
        int i3 = rnd.nextInt(rands.size());
        int i4 = rnd.nextInt(rands.size());
        System.out.printf("dist(%d, %d) = %d", rands.get(i1), rands.get(i2),
                tree.dist(rands.get(i1), rands.get(i2)));
        System.out.printf("\ndist(%d, %d) = %d", rands.get(i3), rands.get(i4),
                tree.dist(rands.get(i3), rands.get(i4)));
        System.out.printf("\ndist(%d, %d) = %d", rands.get(i3), -123,
                tree.dist(rands.get(i3), -123));
        System.out.println(tree.toStringTree());
    }

    /**
     * Assignment 2, Question 1.
     * Check if a binary tree has mirror symmetry in its structure.
     *
     * @return {@code true}, if the binary tree is mirror symmetrical
     */
    public boolean isSymmetrical() {
        return checkSymmetry(root(), root());
    }

    // Recursive helper function to check for mirror symmetry
    private boolean checkSymmetry(Position<E> p1, Position<E> p2) {
        if (p1 == null && p2 == null) {
            return true;
        } else if (p1 != null && p2 != null) {
            return checkSymmetry(left(p1), right(p2)) &&
                    checkSymmetry(right(p1), left(p2));
        } else {
            return false;
        }
    }

    /**
     * Assignment 2, Question 2.
     * Converts a binary tree to its mirror image.
     */
    public void mirror() {
        Node<E> oldRoot = validate(root());
        Node<E> newRoot = validate(mirror(oldRoot));
        setRoot(newRoot);
    }

    // Recursive helper function to convert a tree to its mirror image
    private Node<E> mirror(Node<E> node) {
        if (node != null) {
            // Mirror sub-trees
            Node<E> left = mirror(node.getLeft());
            Node<E> right = mirror(node.getRight());
            // Swap node's children
            node.setLeft(right);
            node.setRight(left);
        }
        return node;
    }

    /**
     * Assignment 2, Question 3.
     * Finds the path length between nodes in a binary tree.
     *
     * @param e1 the element of the first node
     * @param e2 the element of the second node
     * @return distance between the given nodes, or -1 if either node is not in tree
     */
    public int dist(E e1, E e2) {
        Position<E> lca = lowestCommonAncestor(root(), e1, e2);
        return distFromLCA(lca, e1) + distFromLCA(lca, e2);
    }

    // Recursive helper function to find the lowest common ancestor of two nodes
    private Position<E> lowestCommonAncestor(Position<E> root, E e1, E e2) {
        if (root == null || root.getElement().equals(e1) || root.getElement().equals(e2)) {
            return root;
        } else {
            // Search both left and right sub-trees from the root
            Position<E> left = lowestCommonAncestor(left(root), e1, e2);
            Position<E> right = lowestCommonAncestor(right(root), e1, e2);
            if (left != null && right != null) {
                return root;
            } else if (left == null) {
                return right;
            } else {
                return left;
            }
        }
    }

    // Recursive helper function to find the distance between a node and it's lowest common ancestor
    private int distFromLCA(Position<E> lca, E nodeElem) {
        int ans = -1;
        if (lca != null) {
            if (lca.getElement().equals(nodeElem) ||
                    (ans = distFromLCA(left(lca), nodeElem)) >= 0 ||
                    (ans = distFromLCA(right(lca), nodeElem)) >= 0) {
                return ++ans;
            }
        }
        return ans;
    }

}