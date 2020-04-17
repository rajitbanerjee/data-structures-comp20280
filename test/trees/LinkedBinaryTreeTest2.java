package trees;

import org.junit.jupiter.api.Test;
import projectCode20280.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for LinkedBinaryTree.
 *
 * @author Aonghus Lawlor
 */

class LinkedBinaryTreeTest2 {

    @Test
    void testSize() {
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();
        Position<Integer> root = bt.addRoot(1);
        assertEquals(1, bt.size());

        bt.addLeft(root, 2);

        bt.remove(bt.root());
        assertEquals(1, bt.size());
    }

    @Test
    void testAddRoot() {
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();

        Integer c = Integer.parseInt("0");
        bt.addRoot(c);
        assertEquals(c, bt.root().getElement(), "root not added correctly");
    }

    @Test
    void testAddLeft() {
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();

        Integer c = Integer.parseInt("0");
        bt.addRoot(c);
        bt.addLeft(bt.root(), 1);
        assertEquals(1, bt.left(bt.root()).getElement());
    }

    @Test
    void testAddRight() {
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();

        Integer c = Integer.parseInt("0");
        bt.addRoot(c);
        bt.addRight(bt.root(), 1);
        assertEquals(1, bt.right(bt.root()).getElement());
    }

    @Test
    void testRemove() {
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();

        Integer c = Integer.parseInt("0");
        bt.addRoot(c);
        bt.addRight(bt.root(), 1);
        Integer old = bt.remove(bt.right(bt.root()));
        assertEquals(old, 1);
        assertEquals(1, bt.size());
    }

    @Test
    void testToString() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(arr);
        //System.out.println(bt.toString());
        assertEquals("[8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 3, 7]", bt.toString());
    }

    @Test
    void testCreateLevelOrder() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(arr);
        //System.out.println(bt.toString());
        assertEquals("[8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 3, 7]", bt.toString());
    }

    @Test
    void testInorder() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(arr);
        //System.out.println(bt.toString());
        assertEquals("[8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 3, 7]", bt.inorder().toString());
    }

    @Test
    void testDepth() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(arr);

        assertEquals(0, bt.depth(bt.root()));
    }

    @Test
    void testHeight() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>(arr);

        assertEquals(3, bt.height(bt.root()));
    }

}