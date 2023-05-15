
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> implements Iterable {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {

        T element;
        Node<T> prev;
        Node<T> next;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }


    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = current.element;
            current = current.next;
            return element;
        }
    }

    public void add(T e) {
        Node<T> node = new Node<>(last, e, null);
        //if the list is not empty the next pointer of the last node to newNode
        if (last != null) {
            last.next = node;
            //else set first to the newNode
        } else {
            first = node;
        }
        //set the last pointer of the list to the NewNode
        last = node;
        size++;
    }

    public void addFirst(T e) {
        Node<T> node = new Node<>(null, e, first);
        first = node;
        if (first == null) {
            last = node;
        } else {
            first.prev = node;
        }
        size++;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node;
        if (index < (size / 2)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    public void add(int i, T e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (i == size) {
            add(e);
        } else if (i == 0) {
            addFirst(e);
        } else {
            Node<T> node = new Node<>(getNode(i - 1), e, getNode(i));
            getNode(i - 1).next = node;
            getNode(i).prev = node;
            size++;
        }
    }

    public T get(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(i).element;
    }

    private void removeNode(Node<T> node) {
        if (node.prev == null) {
            first = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next == null) {
            last = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;
        if (size == 0) {
            first = null;
            last = null;
        }
    }

    public void remove(T e) {
        for (Node<T> node = first; node != null; node = node.next) {
            if (node.element.equals(e)) {
                removeNode(node);
                break;
            }
        }
    }

    public void remove(int i) {
        Node<T> node = getNode(i);
        removeNode(node);
    }

    public void removeAll(T e) {
        for (Node<T> node = first; node != null; node = node.next) {
            if (node.element.equals(e)) {
                removeNode(node);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder stringOfList = new StringBuilder();
        for (Node<T> current = first; current != null; current = current.next) {
            stringOfList.append(current.element).append(" ");
        }
        return stringOfList.toString().trim();
    }

}
