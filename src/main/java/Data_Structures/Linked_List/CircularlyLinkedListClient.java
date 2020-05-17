package Data_Structures.Linked_List;

/**
 * Class test for CircularlyLinkedList<E>
 */
public class CircularlyLinkedListClient {
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        System.out.println(list.isEmpty());
        System.out.println(list.getSize());

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        System.out.println(list.toString());
        System.out.println(list.first());
        System.out.println(list.last());
    }
}
