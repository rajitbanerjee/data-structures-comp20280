package assignment1;

import lists.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PQSortTest {
    @Test
    void testSort() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(10);
        list.addFirst(40);
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(50);
        assertEquals("[50, 20, 30, 40, 10]", list.toString());

        PQSort<Integer> pq = new PQSort<>();
        pq.sort(list);
        assertEquals("[10, 20, 30, 40, 50]", list.toString());
    }

}
