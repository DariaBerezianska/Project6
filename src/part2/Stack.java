package part2;

import part1.LinkedList;

import java.util.NoSuchElementException;

public class Stack<T> extends LinkedList<T> {

    public void push(T item) {
        addFirst(item); //item is added as the first element of the linked list
    }

    public T pop() {
        if (getSize() == 0) {
            throw new NoSuchElementException();
        }
        T item = get(0); //get the item at the top of the stack
        remove(0); //remove the top item from the stack
        return item;
    }
}
