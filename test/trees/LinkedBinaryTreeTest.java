package trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCode20280.Position;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for LinkedBinaryTree.
 *
 * @author Rajit Banerjee, 18202817
 */

class LinkedBinaryTreeTest {
    private LinkedBinaryTree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new LinkedBinaryTree<>();
    }

    @Test
    void testAddRoot() {
        tree.addRoot(0);
        assertEquals("[0]", tree.toString());
        try {
            tree.addRoot(1);
            fail("Tree already has a root!");
        } catch (Exception ignored) {
            // Test passed
        }
    }

    @Test
    void testAddLeft() {
        Position<Integer> root = tree.addRoot(0);
        Position<Integer> left = tree.addLeft(root, 1);
        assertEquals(root, tree.parent(left));
        // in-order traversal by default
        assertEquals("[1, 0]", tree.toString());
        try {
            tree.addLeft(root, 2);
            fail("Position already has a left child!");
        } catch (Exception ignored) {
            // Test passed
        }
    }

    @Test
    void testAddRight() {
        Position<Integer> root = tree.addRoot(0);
        tree.addRight(root, 1);
        // in-order traversal by default
        assertEquals("[0, 1]", tree.toString());
        try {
            tree.addRight(root, 2);
            fail("Position already has a left child!");
        } catch (Exception ignored) {
            // Test passed
        }
    }

    @Test
    void testInsert() {
        tree.addRoot(1);
        tree.insert(2);
        assertEquals("[1, 2]", tree.toString());
        tree.insert(3);
        assertEquals("[1, 2, 3]", tree.toString());
        tree.insert(0);
        assertEquals("[0, 1, 2, 3]", tree.toString());
        tree.insert(4);
        assertEquals("[0, 1, 2, 3, 4]", tree.toString());

        // Mandatory test from practical
        int[] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
        setUp();
        for (int i : arr) {
            tree.insert(i);
        }
        assertEquals(9, tree.size());
        assertEquals("[12, 25, 31, 36, 42, 58, 62, 75, 90]", tree.toString());
    }

    @Test
    void testSet() {
        Position<Integer> root = tree.addRoot(0);
        Position<Integer> left = tree.addLeft(root, 1);
        Position<Integer> right = tree.addRight(root, 2);
        assertEquals("[1, 0, 2]", tree.toString());
        assertEquals(1, tree.set(left, 3));
        assertEquals("[3, 0, 2]", tree.toString());
        tree.set(root, 4);
        assertEquals("[3, 4, 2]", tree.toString());
        tree.set(right, 5);
        assertEquals("[3, 4, 5]", tree.toString());
    }

    @Test
    void testAttach() {
        LinkedBinaryTree<Integer> t1 = new LinkedBinaryTree<>();
        Position<Integer> root = t1.addRoot(2);
        t1.addLeft(root, 1);
        t1.addRight(root, 3);
        assertEquals("[1, 2, 3]", t1.toString());

        LinkedBinaryTree<Integer> t2 = new LinkedBinaryTree<>();
        root = t2.addRoot(5);
        t2.addLeft(root, 4);
        t2.addRight(root, 6);
        assertEquals("[4, 5, 6]", t2.toString());

        try {
            root = tree.addRoot(0);
            tree.addLeft(root, 1);
            tree.attach(root, t1, t2);
            fail("Position must be a leaf node!");
        } catch (Exception ignored) {
        }

        setUp();
        root = tree.addRoot(0);
        tree.attach(root, t1, t2);
        assertEquals("[1, 2, 3, 0, 4, 5, 6]", tree.toString());

    }

    @Test
    void testRemove() {
        tree.addRoot(0);
        tree.addLeft(tree.root(), 1);
        tree.addRight(tree.root(), 2);
        assertEquals("[1, 0, 2]", tree.toString());
        try {
            tree.remove(tree.root());
            fail("Position has two children! Cannot remove.");
        } catch (Exception ignored) {
            // Test passed
        }
        tree.remove(tree.left(tree.root()));
        assertEquals("[0, 2]", tree.toString());
        tree.remove(tree.root());
        assertEquals("[2]", tree.toString());
        tree.addLeft(tree.root(), 3);
        assertEquals("[3, 2]", tree.toString());
        tree.remove(tree.root());
        assertEquals("[3]", tree.toString());
        tree.addRight(tree.root(), 4);
        assertEquals("[3, 4]", tree.toString());
        tree.remove(tree.right(tree.root()));
        assertEquals("[3]", tree.toString());
    }

    @Test
    void testCountLeftExternalNodes() {
        assertEquals(0, tree.countLeftExternalNodes());
        tree.addRoot(1);
        assertEquals(0, tree.countLeftExternalNodes());
        setUp();
        testInsert();
        assertEquals(0, tree.countLeftExternalNodes());
        tree.addLeft(tree.root(), 11);
        assertEquals(1, tree.countLeftExternalNodes());
        tree.addLeft(tree.right(tree.root()), 20);
        assertEquals(2, tree.countLeftExternalNodes());
    }

    @Test
    void testCountDescendants() {
        assertEquals(0, tree.countDescendants(tree.root()));
        testInsert();
        assertEquals(8, tree.countDescendants(tree.root()));
        assertEquals(7, tree.countDescendants(tree.right(tree.root())));
    }

    @Test
    void testSibling() {
        Position<Integer> root = tree.addRoot(0);
        assertNull(tree.sibling(root));
        Position<Integer> left = tree.addLeft(root, 1);
        Position<Integer> right = tree.addRight(root, 2);
        assertEquals("[1, 0, 2]", tree.toString());
        assertEquals(left, tree.sibling(right));
        assertEquals(right, tree.sibling(left));
    }

    @Test
    void testIsRoot() {
        Position<Integer> root = tree.root();
        assertTrue(tree.isRoot(root));
    }

    @Test
    void testDepth() {
        Position<Integer> root = tree.addRoot(0);
        assertEquals(0, tree.depth(root));
        Position<Integer> right = tree.addRight(root, 1);
        assertEquals(1, tree.depth(right));
    }

    @Test
    void testHeight() {
        Position<Integer> root = tree.addRoot(0);
        assertEquals(0, tree.heightBad());
        assertEquals(0, tree.height(root));
        tree.addLeft(root, 1);
        assertEquals(1, tree.height(root));
        Position<Integer> right = tree.addRight(root, 2);
        assertEquals(1, tree.height(root));
        tree.addLeft(right, 3);
        assertEquals(2, tree.height(root));
        tree.addRight(right, 4);
        assertEquals(2, tree.height(root));
    }

    @Test
    void testTraversal() {
        testInsert();
        assertEquals("[12, 25, 31, 58, 36, 42, 90, 62, 75]",
                tree.preorder().toString());
        assertEquals("[42, 36, 75, 62, 90, 58, 31, 25, 12]",
                tree.postorder().toString());
        assertEquals("[12, 25, 31, 58, 36, 90, 42, 62, 75]",
                tree.breadthFirst().toString());
    }

    @Test
    void testIterator() {
        tree.addRoot(12);
        tree.insert(12);
        tree.insert(12);
        for (Integer i : tree) {
            assertEquals(12, i);
        }
    }

}