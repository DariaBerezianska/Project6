package part3;

import part1.LinkedList;

import java.util.NoSuchElementException;

public class Queue<T> extends LinkedList<T> {
    public void enqueue(T item) {
        add(item); //item is added to the end of the linked list
    }
    public T dequeue(){
        if (getSize() == 0) {
            throw new NoSuchElementException();
        }
        T item = get(0); //get the item at the front of the queue
        remove(0); //remove the front item from the queue
        return item;
    }
}
