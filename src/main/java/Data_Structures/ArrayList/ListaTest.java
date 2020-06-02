package Data_Structures.ArrayList;

public class ListaTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);
        list.add(4, 5);
        list.add(5, 6);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(3));
        System.out.println(list.set(0, 0));
        System.out.println(list);
        System.out.println(list.remove(1));
        System.out.println(list);
        System.out.println(list.set(2, 8));
        System.out.println(list);
    }
}
