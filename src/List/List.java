package List;

import ListElem.ListElem;

import java.util.Iterator;


public class List<T> implements Iterable<T> {
    private ListElem<T> head;
    private final String name;
    private int size = 0;

    public List() {
        head = null;
        name = "";
    }

    public List(String name) {
        head = null;
        this.name = name;
    }

    public ListElem<T> append(T info){
        ListElem<T> newElem = new ListElem<>(info);

        if (head == null) {
            head = newElem;
        } else {
            ListElem<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newElem);
        }
        size++;

        return newElem;
    }

    public ListElem<T> pop() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            ListElem<T> current = head;
            head = null;
            return current;
        } else {
            ListElem<T> current = head.getNext(), previous = head;
            while (current.getNext() != null) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(null);
            size--;

            return current;
        }
    }

    public void clear() {
        head = null;
    }

    public ListElem<T> find(int idx) {
        if (idx >= size) {
            throw new IndexOutOfBoundsException(idx);
        } else {
            ListElem<T> current = head;
            int count = 0;
            while (count != idx) {
                current = current.getNext();
                count++;
            }

            return current;
        }
    }

    public ListElem<T> add(T info, int idx) {
        ListElem<T> elem = new ListElem<>(info);

        if (size == 0) {

            return null;
        } else if (idx >= size) {

            throw new IndexOutOfBoundsException(idx);
        } else {
            ListElem<T> place = find(idx-1);
            ListElem<T> next = place.getNext();
            place.setNext(elem);
            elem.setNext(next);

            return elem;
        }
    }

    public ListElem<T> replace(ListElem<T> elem, int idx) {
        if (size == 0) {

            return null;
        } else if (idx >= size) {

            throw new IndexOutOfBoundsException(idx);
        } else {
            ListElem<T> before = find(idx-1), current = find(idx);
            before.setNext(elem);
            elem.setNext(current.getNext());

            return elem;
        }

    }

    @Override
    public String toString() {
        if (head == null) {

            return null;
        } else {
            String result = "[ " + head.getInfo().toString();
            ListElem<T> current = head;
            while (current.getNext() != null) {
                result += ", " + current.getNext().getInfo().toString();
                current = current.getNext();
            }

            return result + " ]";
        }
    }

    public static <T> List<T> copyList(List<T> list) {
        List<T> newList = new List<T>();
        ListElem<T> current = list.head;
        while (current != null) {
            newList.append(current.getInfo());
            current = current.getNext();
        }

        return newList;
    }

    public int getSize() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ListIterator<T>(head);
    }

    private class ListIterator<E> implements Iterator<E> {
        private ListElem<E> current;

        public ListIterator(ListElem<E> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            ListElem<E> result = current;
            current = current.getNext();
            return result.getInfo();
        }
    }
}
