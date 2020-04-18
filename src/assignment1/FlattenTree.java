package assignment1;

import interfaces.Position;
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
        if (rootPosition != null) {
            Node<E> root = validate(rootPosition);
            flatten(root.getRight());
            if (root.getLeft() != null) {
                flatten(root.getLeft());
                Node<E> temp = root.getLeft();
                while (temp.getRight() != null) {
                    temp = temp.getRight();
                }
                temp.setRight(root.getRight());
                root.setRight(root.getLeft());
                root.setLeft(null);
            }
        }
    }

}