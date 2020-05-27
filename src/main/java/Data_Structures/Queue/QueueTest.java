package Data_Structures.Queue;

public class QueueTest {
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(7);
        queue.enqueue(9);
        queue.enqueue(4);
        queue.enqueue(8);
        queue.enqueue(3);
        queue.enqueue(6);

        System.out.println(queue);              // (7, 9, 4, 8, 3, 6)
        System.out.println(queue.isEmpty());    // false
        System.out.println(queue.size());       // 6
        System.out.println(queue.first());      // 7
        System.out.println(queue.dequeue());    // 7
        System.out.println(queue);              // (9, 4, 8, 3, 6)
        System.out.println(queue.first());      // 9
    }
}
