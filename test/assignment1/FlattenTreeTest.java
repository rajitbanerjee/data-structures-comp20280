package assignment1;

import org.junit.jupiter.api.Test;
import projectCode20280.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Assignment 1, Question 4
 * Test for in-place flattening of a binary tree into
 * a linked list.
 *
 * @author Rajit Banerjee, 18202817
 */

class FlattenTreeTest {
    @Test
    void testFlatten() {
        FlattenTree<Integer> tree = new FlattenTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> rootLeft = tree.addLeft(root, 2);
        Position<Integer> rootRight = tree.addRight(root, 5);
        tree.addLeft(rootLeft, 3);
        tree.addRight(rootLeft, 4);
        tree.addRight(rootRight, 6);

        assertEquals("[3, 2, 4, 1, 5, 6]", tree.toString());
        tree.flatten(root);
        assertEquals("[1, 2, 3, 4, 5, 6]", tree.toString());
    }

}