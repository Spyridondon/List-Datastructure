package Stack;

import ListElem.ListElem;

public class Stack<T> {
    private ListElem<T> first;
    private ListElem<T> top;
    private int size = 0;
    private final String name;

    public Stack(String name) {
        this.name = name;
        first = top = null;
    }

    public Stack() {
        name = null;
        first = top = null;
    }

    public void put(T info) {
        ListElem<T> elem = new ListElem<>(info);
        if (size == 0) {
            first = top = elem;

        } else {
            ListElem<T> current = top;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(elem);
            top = current.getNext();
        }
        size++;
    }

    public ListElem<T> get() {
        if (size == 0) {
            throw new NullPointerException();

        } else if (size == 1) {
            try {
                return top;

            } finally {
                top = null;
                size--;
            }
        } else {
            try {
                return top;

            } finally {
                top = find(size-2);
                size--;
            }
        }
    }

    private ListElem<T> find(int idx) {
        if (idx >= size) {
            throw new IndexOutOfBoundsException(idx);
        } else {
            ListElem<T> current = first;
            int count = 0;
            while (count != idx) {
                current = current.getNext();
                count++;
            }

            return current;
        }
    }

    public int getSize() {
        return size;
    }

    public ListElem<T> getTop() {
        return top;
    }

}
