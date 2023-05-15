package part1;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<T> implements Iterable<T> {
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
        private Node<T> current = first; //current node

        @Override
        public boolean hasNext() {
            return current != null; //check if there's a next node
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = current.element; //get the element of the current node
            current = current.next; //move to the next node
            return element;
        }
    }

    //add an element to the end of the list
    public void add(T e) {
        Node<T> node = new Node<>(last, e, null);
        if (last != null) {
            last.next = node; //if the list is not empty the next pointer of the last node point to newNode
        } else {
            first = node; //else set first to the newNode
        }
        last = node; //update the last node to the new node
        size++;
    }

    //add element to the beginning of the list
    public void addFirst(T e) {
        Node<T> node = new Node<>(null, e, first);
        if (first != null) {
            first.prev = node; //update the previous pointer of the current first node
        }
        first = node; //set the first node to the new node
        if (last == null) {
            last = node; //if the list was empty updating the last node
        }
        size++;
    }

    //get the node at the specified index
    private Node<T> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node;
        if (index < (size / 2)) {
            node = first;
            //traverse the list from the beginning
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            //traverse the list from the end
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    //add element at the specified index
    public void add(int i, T e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (i == size) {
            add(e); //add the element to the end of the list
        } else if (i == 0) {
            addFirst(e); //add the element to the begging of the list
        } else {
            Node<T> node = new Node<>(getNode(i - 1), e, getNode(i));
            getNode(i - 1).next = node; //update the next pointer of the node at index i-1 to the new node
            getNode(i).prev = node; //update the previous pointer of the node at index i to the new node
            size++;
        }
    }

    //get element at the specified index
    public T get(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(i).element; //return the element of the node at the specified index
    }


    //remove node from the list
    private void removeNode(Node<T> node) {
        if (node.prev == null) {
            first = node.next; //node to remove is the first node
        } else {
            node.prev.next = node.next; //node to remove is not the first node
        }
        if (node.next == null) {
            last = node.prev; //node to remove is the last node
        } else {
            node.next.prev = node.prev; //node to remove is not the last node
        }
        size--;
        // if list is empty set first and last to null
        if (size == 0) {
            first = null;
            last = null;
        }
    }

    //remove element that contains e
    public void remove(T e) {
        for (Node<T> node = first; node != null; node = node.next) {
            if (node.element.equals(e)) {
                removeNode(node); //remove the node that contains the element
                break;
            }
        }
    }

    //remove element that has index
    public void remove(int i) {
        Node<T> node = getNode(i); //get the node at the specified index
        removeNode(node); //remove the node
    }

    //remove all elements that contains e
    public void removeAll(T e) {
        for (Node<T> node = first; node != null; node = node.next) {
            if (node.element.equals(e)) {
                removeNode(node); //remove the node that contains the element
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
