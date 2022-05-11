package unidad3.queue;

import java.util.ArrayList;

public class StaticQueue<T>  {
    private final ArrayList<T> queue;
    private final int maxSize;
    private int head;
    private int rear;

    public StaticQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new ArrayList<>(maxSize);
        head = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return head == rear + 1;
    }

    public boolean isFull() {
        return head == rear + 2;
    }

    public void enqueue(T element) {
        if (isFull()) throw new RuntimeException("Queue is full");
        rear = (rear + 1) % maxSize;
        queue.add(rear, element);
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T element = queue.get(head);
        head = (head + 1) % maxSize;
        return element;
    }

    public T peek() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        return queue.get(head);
    }

    public int size() {
        if (isEmpty()) return 0;
        if (head <= rear) return rear - head + 1;
        return maxSize - head + rear + 1;
    }

    @Override
    public String toString() {
        String result = "[";
        for(int i = head; i != rear; i = (i + 1) % maxSize) {
            result += queue.get(i) + ", ";
        }
        result += queue.get(rear) + "]";
        return result;
    }
}
