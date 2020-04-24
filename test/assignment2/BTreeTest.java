package assignment2;

import interfaces.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Assignment 2, Questions 1, 2, 3.
 * Tests for isSymmetrical(), mirror() and dist(p1, p2) in BTree.
 *
 * @author Rajit Banerjee, 18202817
 */

class BTreeTest {
    private BTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BTree<>();

    }

    @Test
    void testIsSymmetrical() {
        // Test asymmetrical
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.addLeft(root, 3);
        Position<Integer> right = tree.addRight(root, 5);
        tree.addLeft(left, 7);
        tree.addRight(tree.addRight(left, 9), 15);
        tree.addRight(right, 13);
        tree.addRight(tree.addLeft(right, 11), 17);
        assertEquals("\n" +
                "      1       \n" +
                "  ┌───┴───┐   \n" +
                "  3       5   \n" +
                "┌─┴─┐   ┌─┴─┐ \n" +
                "7   9   11  13\n" +
                "    └┐  └┐    \n" +
                "     15  17   \n", tree.toStringTree());
        assertFalse(tree.isSymmetrical());

        // Test symmetrical
        setUp();
        root = tree.addRoot(1);
        left = tree.addLeft(root, 3);
        right = tree.addRight(root, 5);
        tree.addLeft(left, 7);
        tree.addLeft(tree.addRight(left, 9), 15);
        tree.addRight(right, 13);
        tree.addRight(tree.addLeft(right, 11), 17);
        assertEquals("\n" +
                "      1       \n" +
                "  ┌───┴───┐   \n" +
                "  3       5   \n" +
                "┌─┴─┐   ┌─┴─┐ \n" +
                "7   9   11  13\n" +
                "   ┌┘   └┐    \n" +
                "   15    17   \n", tree.toStringTree());
        assertTrue(tree.isSymmetrical());
    }

    @Test
    void testMirror() {
        for (int i = 0; i < 5; i++) {
            tree.insert(i);
        }
        assertEquals("\n" +
                "0    \n" +
                "└┐   \n" +
                " 1   \n" +
                " └┐  \n" +
                "  2  \n" +
                "  └┐ \n" +
                "   3 \n" +
                "   └┐\n" +
                "    4\n", tree.toStringTree());
        tree.mirror();
        assertEquals("\n" +
                "    0\n" +
                "   ┌┘\n" +
                "   1 \n" +
                "  ┌┘ \n" +
                "  2  \n" +
                " ┌┘  \n" +
                " 3   \n" +
                "┌┘   \n" +
                "4    \n", tree.toStringTree());
    }

    @Test
    void testDist() {
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.addLeft(root, 3);
        Position<Integer> right = tree.addRight(root, 5);
        tree.addLeft(left, 7);
        tree.addRight(tree.addRight(left, 9), 15);
        tree.addRight(right, 13);
        tree.addRight(tree.addLeft(right, 11), 17);
        assertEquals("\n" +
                "      1       \n" +
                "  ┌───┴───┐   \n" +
                "  3       5   \n" +
                "┌─┴─┐   ┌─┴─┐ \n" +
                "7   9   11  13\n" +
                "    └┐  └┐    \n" +
                "     15  17   \n", tree.toStringTree());
        assertEquals(0, tree.dist(1, 1));
        assertEquals(1, tree.dist(1, 3));
        assertEquals(1, tree.dist(9, 15));
        assertEquals(2, tree.dist(7, 9));
        assertEquals(2, tree.dist(3, 15));
        assertEquals(2, tree.dist(3, 5));
        assertEquals(3, tree.dist(3, 11));
        assertEquals(3, tree.dist(3, 13));
        assertEquals(3, tree.dist(7, 15));
        assertEquals(6, tree.dist(15, 17));
    }

}