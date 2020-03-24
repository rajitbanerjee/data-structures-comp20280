package assignment1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberListTest {

    private NumberList list1;
    private NumberList list2;

    @BeforeEach
    void setUp() {
        list1 = new NumberList();
        list2 = new NumberList();
    }

    @Test
    void testAdd1() {
        list1 = new NumberList(99);
        list2 = new NumberList(99);
        assertEquals("[1, 9, 8]", NumberList.add(list1, list2).toString());
    }

    @Test
    void testAdd2() {
        list1 = new NumberList(104);
        list2 = new NumberList(23);
        assertEquals("[1, 2, 7]", NumberList.add(list1, list2).toString());
    }

    @Test
    void testAdd3() {
        list1 = new NumberList(123);
        list2 = new NumberList(789);
        assertEquals("[9, 1, 2]", NumberList.add(list1, list2).toString());
    }

}
