package unidad3.queue;

public class Main {
    public static void main(String[] args) {
        StaticQueue<Integer> queue = new StaticQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
