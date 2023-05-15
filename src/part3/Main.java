package part3;

public class Main {
    public static void main(String[] args) {
        //Part3 Stack
        System.out.println("Part3 Queue");
        Queue<Integer> queue = new Queue<>();
        //enqueue elements to the stack
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("queue after enqueueing elements: " + queue);
        System.out.println("------------------");
        Integer item1 = queue.dequeue();
        Integer item2 = queue.dequeue();
        System.out.println(item1 + " and " + item2 + " was dequeued");
        System.out.println("queue after dequeueing two elements: " + queue);

    }
}

