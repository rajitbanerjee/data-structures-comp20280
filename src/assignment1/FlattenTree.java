package assignment1;

import projectCode20280.Position;
import trees.LinkedBinaryTree;

/**
 * Assignment 1, Question 4.
 * FlattenTree class adds the flatten function to a LinkedBinaryTree.
 *
 * @author Rajit Banerjee, 18202817
 */
public class FlattenTree<E extends Comparable<E>> extends LinkedBinaryTree<E> {
    /**
     * Algorithm to flatten a binary tree into a linked list.
     *
     * @param rootPosition the root Position of the tree to be flattened
     */
    public void flatten(Position<E> rootPosition) {
        Node<E> root = validate(rootPosition);
        if (root == null || isExternal(root)) {
            return;
        }
        if (root.getLeft() != null) {
            flatten(root.getLeft());

            // temporarily store the original right child of the root
            LinkedBinaryTree.Node<E> originalRight = root.getRight();
            // move the root's left child to it's new right child
            root.setRight(root.getLeft());
            root.setLeft(null);

            // find the rightmost end of the root's right child
            LinkedBinaryTree.Node<E> insertPosition = root.getRight();
            while (insertPosition.getRight() != null) {
                insertPosition = insertPosition.getRight();
            }
            // set the rightmost end's right child to be the original right child
            insertPosition.setRight(originalRight);
        }
        flatten(root.getRight());
    }
    
}
