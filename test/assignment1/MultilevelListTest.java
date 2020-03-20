package assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultilevelListTest {

    // Create a sample multilevel linked list
    public static MultilevelList<Integer> makeMultilevel() {
        MultilevelList<Integer> list1 = new MultilevelList<>(new Integer[]{9, 8, 4, 7, 13});
        MultilevelList<Integer> list2 = new MultilevelList<>(new Integer[]{5, 12, 3});
        MultilevelList<Integer> list3 = new MultilevelList<>(new Integer[]{16, 21});
        MultilevelList<Integer> list4 = new MultilevelList<>(new Integer[]{10});
        MultilevelList<Integer> list5 = new MultilevelList<>(new Integer[]{14});
        MultilevelList<Integer> list6 = new MultilevelList<>(new Integer[]{23, 41});
        MultilevelList<Integer> list7 = new MultilevelList<>(new Integer[]{9});
        MultilevelList<Integer> list8 = new MultilevelList<>(new Integer[]{34, 30});

        list1.insertChild(0, list2);
        list1.insertChild(3, list3);
        list2.insertChild(1, list4);
        list2.insertChild(2, list5);
        list3.insertChild(0, list6);
        list5.insertChild(0, list7);
        list6.insertChild(0, list8);
        return list1;
    }

    @Test
    void testFlatten() {
        MultilevelList<Integer> list = makeMultilevel();
        assertEquals("[9, 8, 4, 7, 13]", list.toString());
        list.flatten(list.head);
        assertEquals("[9, 8, 4, 7, 13, 5, 12, 3, 16, 21, 10, 14, 23, 41, 9, 34, 30]",
                list.toString());
    }

}
