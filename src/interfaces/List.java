package interfaces;

import java.util.Iterator;

/**
 * List ADT interface.
 *
 * @param <E> generic type of elements
 * @author Aonghus Lawlor aonghus.lawlor@ucd.ie
 */

public interface List<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    E get(int i);

    void add(int i, E e);

    void addFirst(E e);

    void addLast(E e);

    E remove(int i);

    E removeFirst();

    E removeLast();

    Iterator<E> iterator();

}