public class ListElem<T> {
    public T info;
    public ListElem<T> next;

    public ListElem(T info) {
        this.info = info;
        next = null;
    }

    public ListElem(T info, ListElem<T> next) {
        this.info = info;
        this.next = next;
    }

    @Override
    public String toString() {

        return info.toString();
    }
}
