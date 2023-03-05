public class List<T> {
    private ListElem<T> head;
    private String name;

    private int size = 0;

    public List() {
        head = null;
        name = null;
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
            while (current.next != null) {
                current = current.next;
            }
            current.next = newElem;
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
            ListElem<T> current = head.next, previous = head;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
            size--;

            return current;
        }
    }

    public void clear() {
        head = null;
    }

    public ListElem<T> get(int idx) {
        if (idx >= size) {
            throw new IndexOutOfBoundsException(idx);
        } else {
            ListElem<T> current = head;
            int count = 0;
            while (count != idx) {
                current = current.next;
                count++;
            }

            return current;
        }
    }

    public ListElem<T> add(ListElem<T> elem, int idx) {
        if (size == 0) {

            return null;
        } else if (idx >= size) {

            throw new IndexOutOfBoundsException(idx);
        } else {
            ListElem<T> place = get(idx-1);
            ListElem<T> next = place.next;
            place.next = elem;
            elem.next = next;

            return elem;
        }
    }

    public ListElem<T> replace(ListElem<T> elem, int idx) {
        if (size == 0) {

            return null;
        } else if (idx >= size) {

            throw new IndexOutOfBoundsException(idx);
        } else {
            ListElem<T> before = get(idx-1), current = get(idx);
            before.next = elem;
            elem.next = current.next;

            return elem;
        }

    }

    @Override
    public String toString() {
        if (head == null) {

            return null;
        } else {
            String result = "[ " + head.info.toString();
            ListElem<T> current = head;
            while (current.next != null) {
                result += ", " + current.next.info.toString();
                current = current.next;
            }

            return result + " ]";
        }
    }

    public static <T> List<T> copyList(List<T> list) {
        List<T> newList = new List<>();
        ListElem<T> current = list.head;
        while (current != null) {
            newList.append(current.info);
            current = current.next;
        }

        return newList;
    }
}
