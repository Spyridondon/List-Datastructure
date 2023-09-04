package ListElem;

public class ListElem<T> {
    private T info;
    private ListElem<T> next;

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

    public ListElem<T> getNext() {
        return next;
    }

    public void setNext(ListElem<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
