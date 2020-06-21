package DataStructures;

public class QueueUsingArraysDriver {
    public static void main(String[] args) throws Exception {
        QueueUsingArrays queue = new QueueUsingArrays();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();

    }
}
