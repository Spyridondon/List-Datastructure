public class Queue<T> {
    private ListElem<T> first, last;
    private int size = 0;
    private final String name;

    public Queue() {
        name = null;
        first = last = null;
    }

    public Queue(String name) {
        this.name = name;
        first = last = null;
    }

    public void put(T info) {
        ListElem<T> elem = new ListElem<>(info);

        if (size == 0) {
            first = last = elem;
        } else {
            ListElem<T> current = first;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(elem);
            last = current.getNext();
        }
        size++;
    }

    public ListElem<T> get() {
        ListElem<T> result = first;
        first = first.getNext();
        size--;
        return result;
    }
}
