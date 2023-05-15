import java.util.NoSuchElementException;

public class Stack<T> extends LinkedList<T> {
    public void push(T item) {
        addFirst(item);
    }

    public T pop() {
        if (getSize() == 0) {
            throw new NoSuchElementException();
        }
        T item = get(0);
        remove(0);
        return item;
    }
}
