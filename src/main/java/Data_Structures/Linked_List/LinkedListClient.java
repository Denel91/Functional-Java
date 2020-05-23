package Data_Structures.Linked_List;

/**
 * Classe di Test per LinkedList<E>
 *
 * @version 25/04/2020
 */
public class LinkedListClient {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(5);
        list.addFirst(3);
        list.addFirst(6);
        list.addFirst(2);
        list.addLast(8);
        list.addLast(9);
        list.addLast(4);
        list.addLast(7);

        System.out.println(list); // (2, 6, 3, 5, 8, 9, 4, 7)
        System.out.println(list.first()); // 2
        System.out.println(list.last()); // 7
        System.out.println(list.getSize()); // 8
        System.out.println(list.isEmpty()); // false
        System.out.println(list.removeFirst()); // 2
        System.out.println(list); // (6, 3, 5, 8, 9, 4, 7)
        list.changeFirst(10);
        list.changeLast(12);
        System.out.println(list); // (10, 3, 5, 8, 9, 4, 12)
        System.out.println(list.indexOf(12)); // 6
        System.out.println(list.indexOf(5)); // 2
        System.out.println(list.indexOf(4)); // 5
        System.out.println(list.indexOf(15)); // -1
        System.out.println(list.indexOf(20)); // -1
        System.out.println(list.belong(9)); // true
        System.out.println(list.belong(3)); // true
        System.out.println(list.belong(12)); // true
        System.out.println(list.belong(15)); // false
        list.display(list); // (10, 3, 5, 8, 9, 4, 12)

        LinkedList<String> listaStringhe = new LinkedList<>();
        listaStringhe.addFirst("Hello");
        listaStringhe.addLast("World");
        listaStringhe.addLast("LinkedList");
        System.out.println();
        System.out.println(listaStringhe); // (Hello, World, LinkedList)
        System.out.println(listaStringhe.indexOf("LinkedList")); // 2
    }
}
