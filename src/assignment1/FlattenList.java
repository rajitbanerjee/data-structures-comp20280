package assignment1;

/**
 * Implementation of an algorithm to flatten
 * a multi-level linked list.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class FlattenList {

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

    public static void main(String[] args) {
        MultilevelList<Integer> list = makeMultilevel();
        list.flatten(list.head);
        System.out.println(list.toString());
    }

}
